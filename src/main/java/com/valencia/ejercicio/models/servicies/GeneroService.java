package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IGenero;
import com.valencia.ejercicio.models.entities.Genero;
@Service
public class GeneroService implements IGeneroService {
	@Autowired//Inyeccion de dependencia
	private IGenero dao;
	
	@Override
	@Transactional
	public void save(Genero a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Genero findById(Integer id) {
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
	public List<Genero> findAll() {
		// TODO Auto-generated method stub
		return (List<Genero> )dao.findAll();
	}
}
