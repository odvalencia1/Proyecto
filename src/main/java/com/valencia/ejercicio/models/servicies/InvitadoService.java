package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IInvitado;
import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.entities.Invitado;



@Service
public class InvitadoService implements IInvitadoService {
	@Autowired//Inyeccion de dependencia
	private IInvitado dao;
	
	@Override
	@Transactional
	public void save(Invitado a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Invitado findById(Integer id) {
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
	public List<Invitado> findAll() {
		// TODO Auto-generated method stub
		return (List<Invitado> )dao.findAll();
	}
	
	@Override
	@Transactional
	public List<Invitado> findByEvento(Evento id) {
		// TODO Auto-generated method stub
		return (List<Invitado> ) dao.findByEvento(id);
	}

	@Override
	public List<Invitado> findByArtistaInvitado(Artista artista) {
		// TODO Auto-generated method stub
		return (List<Invitado> ) dao.findByArtistaInvitado(artista);
	}
	
	
}
