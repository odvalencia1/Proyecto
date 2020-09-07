package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IArtista;
import com.valencia.ejercicio.models.entities.Artista;



@Service
public class ArtistaService implements IArtistaService {
	@Autowired//Inyeccion de dependencia
	private IArtista dao;
	
	@Override
	@Transactional
	public void save(Artista a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Artista findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Artista> findAll() {
		// TODO Auto-generated method stub
		return (List<Artista> )dao.findAll();
	}
	
	@Override
	@Transactional
	public List<Artista> findNombre(String nombre) {
		// TODO Auto-generated method stub
		return (List<Artista> )dao.findByNombreArtisticoLike(nombre);
	}

	@Override
	@Transactional
	public List<Artista> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return dao.findByNombreArtisticoStartingWith(nombre);
	}
}
