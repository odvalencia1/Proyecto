package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Mensaje;

public interface IMensajeService {
	public void save(Mensaje m);
	public List<Mensaje> findAll();
	public void delete(Integer id);
}
