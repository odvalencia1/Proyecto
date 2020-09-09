package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Artista;

public interface IArtistaService {
	public void save(Artista a);
	public Artista findById(Integer id);
	public void delete(Integer id);
	public List<Artista> findAll();
	public List<Artista> findNombre(String nombre);
	public List<Artista> findByNombre(String nombreArtistico);
}
