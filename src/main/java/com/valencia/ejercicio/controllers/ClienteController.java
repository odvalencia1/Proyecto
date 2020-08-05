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

import com.valencia.ejercicio.models.entities.Cliente;
import com.valencia.ejercicio.models.servicies.IClienteService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	private IClienteService srvCliente;
	@GetMapping(value="/create")//https://localhost:8080/Cliente/create
	public String create(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("title","Registro de nuevo Cliente");
		model.addAttribute("cliente",cliente);model.addAttribute("cliente",cliente);
		
		return "Cliente/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve (@PathVariable(value="id")Integer id, Model model, RedirectAttributes flash) {
		Cliente cliente = srvCliente.findById(id);
		if(cliente == null) {
			flash.addFlashAttribute("error","El  cliente no existe en la base de datos");
			return "redirect: Cliente/list";
		}
		else {
		model.addAttribute("cliente",cliente);
		model.addAttribute("title","Registro de "+" " + cliente.getNombre());
		
		return "Cliente/card";
		}
	}
	
	@GetMapping(value="/update/{id}")
	public String update (@PathVariable(value="id")Integer id, Model model,RedirectAttributes flash) {
		Cliente cliente = srvCliente.findById(id);
		model.addAttribute("cliente",cliente);
		model.addAttribute("title","Actalizando el registro de"+" " + cliente.getNombre());
		return "cliente/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete (@PathVariable(value="id")Integer id, Model model) {
		srvCliente.delete(id);
		return "redirect:/cliente/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes",clientes);
		model.addAttribute("title","Listado de Clientes");
		return "cliente/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/Cliente/create
	public String save(Cliente cliente, Model model) {
		
		this.srvCliente.save(cliente);
		return "redirect:/cliente/list";
	}
}
