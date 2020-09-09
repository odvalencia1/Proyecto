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

import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.models.servicies.IGeneroService;

@Controller
@RequestMapping(value="/genero")
public class GeneroController {

	@Autowired
	private IGeneroService srvGenero;
	
	@GetMapping(value="/create")
	public String Create(Model model) {
		Genero genero = new Genero();
		List<Genero> generos = srvGenero.findAll();
		
		model.addAttribute("genero", genero);
		model.addAttribute("generos",generos);
				
		return "genero/generoAdd";
	}
	
	@PostMapping(value="/save")
	public String Save(Genero genero, Model model) {
		srvGenero.save(genero);
		
		return "redirect:/genero/create";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model,RedirectAttributes flash) {
		srvGenero.delete(id);
		return "redirect:/genero/create";	
	}

}
