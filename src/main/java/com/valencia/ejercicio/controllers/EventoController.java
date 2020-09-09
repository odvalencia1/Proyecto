package com.valencia.ejercicio.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
>>>>>>> ccc5c3c5911bb6ea9230c1c7d010659173c9bc99
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.entities.Invitado;
import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Cliente;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.servicies.IArtistaService;
import com.valencia.ejercicio.models.servicies.IClienteService;
import com.valencia.ejercicio.models.servicies.IEventoService;
<<<<<<< HEAD
import com.valencia.ejercicio.models.servicies.ITipoEstadoService;
import com.valencia.ejercicio.reporting.RptEventoArtista;
=======
>>>>>>> ccc5c3c5911bb6ea9230c1c7d010659173c9bc99


@Controller
@SessionAttributes("Evento")
@RequestMapping(value="/evento")
public class EventoController {
	
	@Autowired
	private IEventoService srvEvento;
	@Autowired
	private IClienteService srvCliente;
	
	@Autowired
	private IArtistaService srvArtista;
	
	@GetMapping(value="/create")//https://localhost:8080/Evento/create
	public String create(Model model) {
		Evento evento = new Evento();
		evento.setInvitados(new ArrayList<Invitado>());
		model.addAttribute("title","Registro de nuevo Evento");
		model.addAttribute("Evento",evento);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes",clientes);
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
	public String save(@Validated Evento evento, BindingResult result,Model model,SessionStatus status, RedirectAttributes flash, HttpSession session) {
		try {
			String message = "Evento agregado con exito";
			String titulo = "Registro de un nuevo Evento";
			if(evento.getIdEvento() != null) {
				message = "Evento actualizado con exito";
				titulo = "Actualizando Evento " + evento.getNombre();
			}
			if(result.hasErrors()) {
				model.addAttribute("title",titulo);
				model.addAttribute("error", "Complete todos los campos");
				List<Cliente> clientes = srvCliente.findAll();
				model.addAttribute("clientes",clientes);
				return "evento/form";
			}
			Evento eventoSession = (Evento) session.getAttribute("Evento");
			for(Invitado i : eventoSession.getInvitados()) {
				evento.getInvitados().add(i);
			}
			
			srvEvento.save(evento);
			status.setComplete();
			flash.addFlashAttribute("success", message);
			
		}
		catch(Exception ex) {
			flash.addFlashAttribute("success", ex.getMessage());
		}
		return "redirect:/evento/list";
	}
	
<<<<<<< HEAD
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
	
	
=======
	@PostMapping(value = "/add", produces="application/json")
	public @ResponseBody Object add(@RequestBody @Valid Invitado invitado, 
			BindingResult result, Model model, HttpSession session) {				
		try {
			Artista artista = this.srvArtista.findById(invitado.getArtistaid());			
			invitado.setArtistaInvitado(artista);
			Evento evento = (Evento) session.getAttribute("Evento");
			evento.getInvitados().add(invitado);
			return invitado;
		} catch (Exception ex) {			
			return ex;
		}		
	}
	
	@GetMapping(value = "/artis")
	public String artis(Model model, HttpSession session) {
		Evento evento = (Evento) session.getAttribute("Evento");
		model.addAttribute("artis", evento.getInvitados().toArray());		
		model.addAttribute("title", "Listado de Artistas Invitados");
		return "invitado/list";
	}
>>>>>>> ccc5c3c5911bb6ea9230c1c7d010659173c9bc99
}
