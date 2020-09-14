package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.reporting.RptEventoArtista;
import com.valencia.ejercicio.reporting.RptEventoArtistaGeneroMusical;
import com.valencia.ejercicio.reporting.RptEventoMes;

public interface IEventoService {
	public void save(Evento a);
	public Evento findById(Integer id);
	public void delete(Integer id);
	public List<Evento> findAll();
	public List<RptEventoArtista> rptEventoArtista();
	public List<RptEventoMes> rptEventoMes(Integer id);
	public List<List<RptEventoArtistaGeneroMusical>> rptEventoArtistaGeneroMusical(List<Evento> eventos);
	
	
}
