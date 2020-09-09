package com.valencia.ejercicio.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Instrumento;
import com.valencia.ejercicio.models.entities.Integrante;
import com.valencia.ejercicio.models.entities.Usuario;
import com.valencia.ejercicio.models.servicies.IArtistaService;
import com.valencia.ejercicio.models.servicies.IInstrumentoService;
import com.valencia.ejercicio.models.servicies.IIntegranteService;
import com.valencia.ejercicio.models.servicies.UsuarioService;



@Controller
@RequestMapping(value="/integrante")
public class IntegranteController {
	
	@Autowired
	private IIntegranteService srvIntegrante;
	
	@Autowired
	private IInstrumentoService srvInstrumento;
	
	@Autowired
	private UsuarioService srvUsuario;
	
	@Autowired
	private IArtistaService srvArtista;
	
	@GetMapping(value="/add")//https://localhost:8080/integrante/add
	public String add(Model model) {
		
		Integrante integrante = new Integrante();
			
		//List<Integrante> integrantes = srvIntegrante.findAll();
		List<Integrante> integrantes = this.BuscarArtista().getIntegrantes();

		//List<Integrante> integrantes = srvIntegrante.findById(BuscarArtista().getIdArtista());
		//de aqui va la lista con los instrumentos
		List<Instrumento> instrumentos = srvInstrumento.findAll();
		model.addAttribute("integrantes",integrantes);
		
		model.addAttribute("integrante", integrante);
		model.addAttribute("instrumentos", instrumentos);
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
				integrante.setArtista(this.BuscarArtista());
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
			
		
		this.srvIntegrante.save(integrante);
		return "redirect:/integrante/add";
	}
	
	//devuelve el artista en sesion
	public Artista BuscarArtista() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		Usuario usuario = this.srvUsuario.findUserByName(userName);
		return usuario.getArtista();
	}


	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model,RedirectAttributes flash) {
		srvIntegrante.delete(id);
		flash.addFlashAttribute("success", "Se ha eliminado con exito");
		return "redirect:/integrante/add";		
	}

}
