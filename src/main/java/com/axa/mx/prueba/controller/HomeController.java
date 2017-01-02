package com.axa.mx.prueba.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.axa.mx.prueba.DAO.UsuariosDAO;
import com.axa.mx.prueba.DTO.UsuariosDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/*@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}*/
	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    List<UsuariosDTO> listContact = usuariosDAO.list();
	    model.addObject("listContact", listContact);
	    model.setViewName("home");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
	    UsuariosDTO newUser = new UsuariosDTO();
	    model.addObject("contact", newUser);
	    model.setViewName("ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute UsuariosDTO usuariosDTO) {
	    usuariosDAO.saveOrUpdate(usuariosDTO);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    String usuarioID = (request.getParameter("id"));
	    usuariosDAO.delete(usuarioID);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
		public ModelAndView editContact(HttpServletRequest request) {
	    String usuarioID = (request.getParameter("id"));
	    UsuariosDTO usuario = usuariosDAO.get(usuarioID);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("contact", usuario);
	 
	    return model;
	}
	
	
}
