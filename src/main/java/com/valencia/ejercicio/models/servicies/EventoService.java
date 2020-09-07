package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IEvento;
import com.valencia.ejercicio.models.dao.IInvitado;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.entities.Invitado;

@Service
public class EventoService implements IEventoService {
	@Autowired//Inyeccion de dependencia
	private IEvento dao;
	
	@Autowired
	private IInvitado daoInvitado;
	
	@Override
	@Transactional
	public void save(Evento a) {
		try {
			dao.save(a);
			for(Invitado i : a.getInvitados()) {
				i.setEvento(a);
				this.daoInvitado.save(i);			
			}
		}
		catch(Exception ex) {
				throw ex;
		}
		
		
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
