//This class simply maps a row in the table slw_usuarios to a plain old Java object (POJO)

package com.axa.mx.prueba.DTO;

import java.sql.Date;

public class UsuariosDTO {

	private int flgActivo;
	private String idUsuarioCreador;
	private Date dateCreacion;
	private String idUsuarioModificador;
	private String pkGmysSlwUsuario;

	public UsuariosDTO() {

	}

	public UsuariosDTO(int flgActivo, String idUsuarioCreador, Date dateCreacion, String idUsuarioModificador) {

		this.flgActivo = flgActivo;
		this.idUsuarioCreador = idUsuarioCreador;
		this.dateCreacion = dateCreacion;
		this.idUsuarioModificador = idUsuarioModificador;

	}

	public Integer getFlgActivo() {
		return flgActivo;
	}

	public void setFlgActivo(Integer flgActivo) {
		this.flgActivo = flgActivo;
	}

	public String getIdUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setIdUsuarioCreador(String idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	public Date getDateCreacion() {
		return dateCreacion;
	}

	public void setDateCreacion(Date dateCreacion) {
		this.dateCreacion = dateCreacion;
	}

	public String getIdUsuarioModificador() {
		return idUsuarioModificador;
	}

	public void setIdUsuarioModificador(String idUsuarioModificador) {
		this.idUsuarioModificador = idUsuarioModificador;
	}

	public String getPkGmysSlwUsuario() {
		return pkGmysSlwUsuario;
	}

	public void setPkGmysSlwUsuario(String pkGmysSlwUsuario) {
		this.pkGmysSlwUsuario = pkGmysSlwUsuario;
	}

	public void setFlgActivo(int flgActivo) {
		this.flgActivo = flgActivo;
	}

}
