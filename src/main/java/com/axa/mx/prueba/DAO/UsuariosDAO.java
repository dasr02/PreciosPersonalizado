package com.axa.mx.prueba.DAO;

import java.util.List;
import com.axa.mx.prueba.DTO.UsuariosDTO;


public interface UsuariosDAO {
	
		public void saveOrUpdate(UsuariosDTO UsuariosDTO);
     
	    public void delete(String pkGmysSlwUsuario);
	     
	    public UsuariosDTO get(String pkGmysSlwUsuario);
	     
	    public List<UsuariosDTO> list();
}
