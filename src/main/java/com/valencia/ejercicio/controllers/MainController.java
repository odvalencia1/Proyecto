package com.valencia.ejercicio.controllers;

import java.security.Principal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.servicies.IArtistaService;



@Controller
@RequestMapping(value="/")
public class MainController {
	@Autowired
	private IArtistaService srvArtista;
	
	@GetMapping(value= {"/","/index.html"})
	public String home(Model model) {
		List<Artista> artistas = srvArtista.findAll();
		model.addAttribute("artistas",artistas);
		//el retorno de la vista  que se va a desplegar
		return "index";
	}
	
	
	@GetMapping(value="/elements.html")
	public String elemets(Model model) {
		//el retorno de la vista  que se va a desplegar
		return "elements";
	}
	
	@GetMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, 
		Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "El usuario ya tiene una sesión activa.");
			return "redirect:/";
		}		
		if(error != null) {
			model.addAttribute("error", "Usuario o contraseña incorrectas");
		}				
		return "login";
	}
}
