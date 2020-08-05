package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.TipoEstado;

public interface ITipoEstadoService {
	public void save(TipoEstado a);
	public TipoEstado findById(Integer id);
	public void delete(Integer id);
	public List<TipoEstado> findAll();
}
