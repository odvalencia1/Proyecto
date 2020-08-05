package com.valencia.ejercicio.controllers;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valencia.ejercicio.models.servicies.IArtistaService;
import com.valencia.ejercicio.models.servicies.IGeneroService;
import com.valencia.ejercicio.models.servicies.UsuarioService;
import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.models.entities.Rol;
import com.valencia.ejercicio.models.entities.Usuario;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IArtistaService srvArtista;
	
	@Autowired
	private IGeneroService srvGenero;
	
	@GetMapping(value="/create")
	public String registro(Model model) {
		Artista artista = new Artista();
		model.addAttribute("artista",artista);
		List<Genero> generos = srvGenero.findAll();
		model.addAttribute("generos",generos);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Registro de nuevo usuario");				
		return "usuario/form";
	}
	
	
	@PostMapping(value="/save")
	public String save(@Validated Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash, @RequestParam("file") MultipartFile foto) {
		Artista artista = new Artista();
		artista.setNombreArtistico(usuario.getArtista().getNombreArtistico());
		artista.setCorreo(usuario.getArtista().getCorreo());
		artista.setGenero(usuario.getArtista().getGenero());
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//"+foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				artista.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		this.srvArtista.save(artista);
		usuario.setArtista(artista);
		try {
			if(result.hasErrors())
			{	
				model.addAttribute("title", "Registro de nuevo usuario");
				model.addAttribute("usuario", usuario);
				model.addAttribute("artista",artista);
				List<Genero> generos = srvGenero.findAll();
				model.addAttribute("generos",generos);
				return "usuario/form";
			}			
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));			
			usuario.getRoles().add(new Rol("ROLE_USER"));
			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El usuario fue agregado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El usuario no pudo ser agregado.");
		}
		return "redirect:/login";		
	} 
}
