package com.valencia.ejercicio.models.servicies;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IEvento;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.reporting.RptEventoArtista;

@Service
public class EventoService implements IEventoService {
	@Autowired//Inyeccion de dependencia
	private IEvento dao;
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	@Transactional
	public void save(Evento a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Evento findById(Integer id) {
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
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return (List<Evento> )dao.findAll();
	}

	@Override
	public List<RptEventoArtista> rptEventoArtista() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("eventos_por_artista");
		query.execute();
		List<Object[]> datos = query.getResultList();
		return datos.stream()
				.map(r-> new RptEventoArtista((String)r[0],(BigInteger)r[1] ))
				.collect(Collectors.toList());
	}

	
}
