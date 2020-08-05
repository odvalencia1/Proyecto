package com.valencia.ejercicio.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;


import com.valencia.ejercicio.models.entities.Integrante;
import com.valencia.ejercicio.models.servicies.IIntegranteService;



@Controller
@RequestMapping(value="/integrante")
public class IntegranteController {
	
	@Autowired
	private IIntegranteService srvIntegrante;
	
	
	@GetMapping(value="/add")//https://localhost:8080/integrante/add
	public String add(Model model) {
		
		Integrante integrante = new Integrante();
			
		List<Integrante> integrantes = srvIntegrante.findAll();
		model.addAttribute("integrantes",integrantes);
		model.addAttribute("integrante", integrante);
		return "integrante/integranteAdd";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/Artista/create
	public String save(Integrante integrante, Model model,  @RequestParam("file") MultipartFile foto) {
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//"+foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				integrante.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
			
		//Artista artista = (Artista) session.getAttribute("idrArtista");
		//integrante.getArtista().setIdArtista(artista.idArtista);
		
		this.srvIntegrante.save(integrante);
		return "redirect:/integrante/add";
	}
}
