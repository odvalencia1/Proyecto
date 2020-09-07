package com.valencia.ejercicio.models.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Artista;


public interface IArtista extends CrudRepository<Artista, Integer>{
	public List<Artista> findByNombreArtisticoLike(String nombre);
	public List<Artista> findByNombreArtisticoStartingWith(String nombreArtistico);
	public List<Artista> findByNombreArtisticoStartsWith(String nombre);
	
}
