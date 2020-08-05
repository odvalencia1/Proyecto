package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.ITipoEstado;
import com.valencia.ejercicio.models.entities.TipoEstado;

@Service
public class TipoEstadoService implements ITipoEstadoService {
	@Autowired//Inyeccion de dependencia
	private ITipoEstado dao;
	
	@Override
	@Transactional
	public void save(TipoEstado a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public TipoEstado findById(Integer id) {
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
	public List<TipoEstado> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoEstado> )dao.findAll();
	}
}
