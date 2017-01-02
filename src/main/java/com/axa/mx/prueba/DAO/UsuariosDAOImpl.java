package com.axa.mx.prueba.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.axa.mx.prueba.DTO.UsuariosDTO;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class UsuariosDAOImpl implements UsuariosDAO {

	private JdbcTemplate jdbcTemplate;

	public UsuariosDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void saveOrUpdate(UsuariosDTO UsuariosDTO) {

		if (UsuariosDTO.getPkGmysSlwUsuario() != null) {
			// update
			String sql = "UPDATE GMYS_SLW_USUARIOS SET FLG_ACTIVO=?, ID_USUARIO_CREADOR=?, DATE_CREACION=?, "
					+ "ID_USUARIO_MODIFICADOR=? WHERE PK_GMYS_SLW_USUARIO=?";
			jdbcTemplate.update(sql, UsuariosDTO.getFlgActivo(), UsuariosDTO.getIdUsuarioCreador(),
					UsuariosDTO.getDateCreacion(), UsuariosDTO.getIdUsuarioModificador(),
					UsuariosDTO.getPkGmysSlwUsuario());
		} else {
			// insert
			String sql = "INSERT INTO GMYS_SLW_USUARIOS (FLG_ACTIVO, ID_USUARIO_CREADOR, DATE_CREACION, ID_USUARIO_MODIFICADOR,PK_GMYS_SLW_USUARIO)" + " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, UsuariosDTO.getFlgActivo(), UsuariosDTO.getIdUsuarioCreador(),
					UsuariosDTO.getDateCreacion(), UsuariosDTO.getIdUsuarioModificador(),
					UsuariosDTO.getPkGmysSlwUsuario());
		}

	}

	@Override
	public void delete(String pkGmysSlwUsuario) {
		String sql = "DELETE FROM GMYS_SLW_USUARIOS WHERE PK_GMYS_SLW_USUARIO =?";
		jdbcTemplate.update(sql, pkGmysSlwUsuario);

	}

	@Override
	public UsuariosDTO get(String pkGmysSlwUsuario) {
		String sql = "SELECT * FROM GMYS_SLW_USUARIOS WHERE PK_GMYS_SLW_USUARIO=" + pkGmysSlwUsuario;
		return jdbcTemplate.query(sql, new ResultSetExtractor<UsuariosDTO>() {

			@Override
			public UsuariosDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UsuariosDTO aContact = new UsuariosDTO();
					aContact.setFlgActivo(rs.getInt("FLG_ACTIVO"));
					aContact.setIdUsuarioCreador(rs.getString("ID_USUARIO_CREADOR"));
					aContact.setDateCreacion(rs.getDate("DATE_CREACION"));
					aContact.setIdUsuarioModificador(rs.getString("ID_USUARIO_MODIFICADOR"));
					aContact.setPkGmysSlwUsuario(rs.getString("PK_GMYS_SLW_USUARIO"));
					return aContact;
				}

				return null;
			}

		});
	}

	@Override
	public List<UsuariosDTO> list() {
		String sql = "SELECT * FROM GMYS_SLW_USUARIOS";
		List<UsuariosDTO> listUsuarios = jdbcTemplate.query(sql, new RowMapper<UsuariosDTO>() {

			@Override
			public UsuariosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UsuariosDTO aContact = new UsuariosDTO();

				aContact.setFlgActivo(rs.getInt("FLG_ACTIVO"));
				aContact.setIdUsuarioCreador(rs.getString("ID_USUARIO_CREADOR"));
				aContact.setDateCreacion(rs.getDate("DATE_CREACION"));
				aContact.setIdUsuarioModificador(rs.getString("ID_USUARIO_MODIFICADOR"));
				aContact.setPkGmysSlwUsuario(rs.getString("PK_GMYS_SLW_USUARIO"));

				return aContact;
			}

		});

		return listUsuarios;
	}

}
