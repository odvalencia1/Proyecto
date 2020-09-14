package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IMensaje;

import com.valencia.ejercicio.models.entities.Mensaje;

@Service
public class MensajeService implements IMensajeService{

	@Autowired
	private IMensaje dao;
	
	@Override
	@Transactional
	public void save(Mensaje m) {
		dao.save(m);
		
	}

	@Override
	@Transactional
	public List<Mensaje> findAll() {
		return (List<Mensaje> )dao.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

}
