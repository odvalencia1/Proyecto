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

import com.valencia.ejercicio.models.entities.Instrumento;
import com.valencia.ejercicio.models.servicies.IInstrumentoService;

@Controller
@RequestMapping(value="/instrumento")
public class InstrumentoController {
	
	@Autowired
	private IInstrumentoService srvInstrumento;
	
	@GetMapping(value="/create")
	public String Create(Model model) {
		Instrumento instrumento = new Instrumento();
		
		List<Instrumento> instrumentos = srvInstrumento.findAll();
		model.addAttribute("instrumentos", instrumentos);
		model.addAttribute("instrumento", instrumento);
		return "instrumento/instrumentoAdd";
	}
	
	@PostMapping(value="/save")
	public String Save(Instrumento instrumento, Model model) {
		srvInstrumento.save(instrumento);
		return "redirect:/instrumento/create";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model,RedirectAttributes flash) {
		srvInstrumento.delete(id);
		flash.addFlashAttribute("success", "Se ha eliminado con exito");
		return "redirect:/instrumento/create";		
	}
}
