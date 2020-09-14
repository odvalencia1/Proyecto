package com.valencia.ejercicio.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.entities.Mensaje;
import com.valencia.ejercicio.models.servicies.IMensajeService;

@Controller
@RequestMapping(value="/mensaje")
public class MensajeController {

	@Autowired
	private IMensajeService srvMensaje;
	
	@GetMapping(value="/create")
	private String Create(Model model) {
		Mensaje mensaje = new Mensaje();
		model.addAttribute("mensaje", mensaje);
		
		return "contact";
	}
	
	@PostMapping(value="/save")
	public String Save(Mensaje mensaje, Model model) {
		srvMensaje.save(mensaje);
		return "contact";
	}
	
	@GetMapping(value="/delete/{id}")
	public String Delete(@PathVariable(value="id") Integer id, Model model,RedirectAttributes flash) {
		srvMensaje.delete(id);
		
		return "redirect:/mensaje/list";
	}
	
	@GetMapping(value="/list")
	public String List(Model model) {
		List<Mensaje> mensajes=  srvMensaje.findAll();
		model.addAttribute("mensajes", mensajes);
		return "mensaje/list";
	}
	
}
