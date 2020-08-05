package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IEvento;
import com.valencia.ejercicio.models.entities.Evento;

@Service
public class EventoService implements IEventoService {
	@Autowired//Inyeccion de dependencia
	private IEvento dao;
	
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

	
}
