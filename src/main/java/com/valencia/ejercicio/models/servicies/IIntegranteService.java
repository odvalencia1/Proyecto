package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Integrante;

public interface IIntegranteService {
	public void save(Integrante a);
	public Integrante findById(Integer id);
	public void delete(Integer id);
	public List<Integrante> findAll();
}
