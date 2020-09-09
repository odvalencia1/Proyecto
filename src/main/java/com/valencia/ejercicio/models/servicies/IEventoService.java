package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.reporting.RptEventoArtista;

public interface IEventoService {
	public void save(Evento a);
	public Evento findById(Integer id);
	public void delete(Integer id);
	public List<Evento> findAll();
	public List<RptEventoArtista> rptEventoArtista();
	
	
}
