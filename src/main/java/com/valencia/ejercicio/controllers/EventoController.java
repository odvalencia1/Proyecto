package com.valencia.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Cliente;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.entities.TipoEstado;
import com.valencia.ejercicio.models.servicies.IArtistaService;
import com.valencia.ejercicio.models.servicies.IClienteService;
import com.valencia.ejercicio.models.servicies.IEventoService;
import com.valencia.ejercicio.models.servicies.ITipoEstadoService;
import com.valencia.ejercicio.reporting.RptEventoArtista;


@Controller
@RequestMapping(value="/evento")
public class EventoController {
	
	@Autowired
	private IEventoService srvEvento;
	@Autowired
	private IClienteService srvCliente;
	@Autowired
	private ITipoEstadoService srvEstado;
	@Autowired
	private IArtistaService srvArtista;
	
	@GetMapping(value="/create")//https://localhost:8080/Evento/create
	public String create(Model model) {
		Evento evento = new Evento();
		model.addAttribute("title","Registro de nuevo Evento");
		model.addAttribute("evento",evento);
		List<TipoEstado> estados = srvEstado.findAll();
		model.addAttribute("estados", estados);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes",clientes);
		List<Artista> artistas = srvArtista.findAll();
		model.addAttribute("artistas",artistas);
		return "evento/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve (@PathVariable(value="id")Integer id, Model model, RedirectAttributes flash) {
		Evento evento = srvEvento.findById(id);
		if(evento == null) {
			flash.addFlashAttribute("error","El  cliente no existe en la base de datos");
			return "redirect: evento/list";
		}
		else {
		model.addAttribute("evento",evento);
		model.addAttribute("title","Registro de "+" " + evento.getNombre());
		List<TipoEstado> estados = srvEstado.findAll();
		model.addAttribute("estados", estados);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes",clientes);
		List<Artista> artistas = srvArtista.findAll();
		model.addAttribute("artistas",artistas);
		return "evento/card";
		}
	}
	
	@GetMapping(value="/update/{id}")
	public String update (@PathVariable(value="id")Integer id, Model model,RedirectAttributes flash) {
		Evento evento = srvEvento.findById(id);
		model.addAttribute("evento",evento);
		List<TipoEstado> estados = srvEstado.findAll();
		model.addAttribute("estados", estados);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes",clientes);
		List<Artista> artistas = srvArtista.findAll();
		model.addAttribute("artistas",artistas);
		model.addAttribute("title","Actalizando el registro de"+" " + evento.getNombre());
		return "evento/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete (@PathVariable(value="id")Integer id, Model model) {
		srvEvento.delete(id);
		return "redirect:/evento/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Evento> eventos = srvEvento.findAll();
		model.addAttribute("eventos",eventos);
		model.addAttribute("title","Listado de Eventos");
		return "evento/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/Evento/create
	public String save(Evento evento, Model model) {
		
		this.srvEvento.save(evento);
		return "redirect:/evento/list";
	}
	
	@GetMapping(value = "/rptEventosArtistas")
	public String rptEventosArtista(Model model) {
		return "evento/rptEventosArtistas";
	}
	
	@GetMapping(value="/dataRptEventosArtistas", produces="application/json")
	public @ResponseBody List<RptEventoArtista> dataRptEventosArtista(Model model){
		try {
			return this.srvEvento.rptEventoArtista();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	
}
