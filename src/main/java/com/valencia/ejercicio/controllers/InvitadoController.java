package com.valencia.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valencia.ejercicio.models.entities.Invitado;

@Controller
@RequestMapping(value="/invitado") 
public class InvitadoController {
	@GetMapping(value="/create") 
	public String create(Model model) {
		Invitado invitado = new Invitado();
		model.addAttribute("invitado", invitado);
		return "invitado/form"; 
	}
}
