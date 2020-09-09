package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Instrumento;

public interface IInstrumentoService {

	public void save(Instrumento i);
	public List<Instrumento> findAll();
	public void delete(Integer id);
}
