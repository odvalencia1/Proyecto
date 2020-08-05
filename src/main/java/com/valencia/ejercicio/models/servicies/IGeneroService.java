package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Genero;

public interface IGeneroService {
	public void save(Genero a);
	public Genero findById(Integer id);
	public void delete(Integer id);
	public List<Genero> findAll();
}
