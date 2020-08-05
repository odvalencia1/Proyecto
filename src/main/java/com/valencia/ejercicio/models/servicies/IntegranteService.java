package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IIntegrante;
import com.valencia.ejercicio.models.entities.Integrante;
@Service
public class IntegranteService implements IIntegranteService{
	@Autowired//Inyeccion de dependencia
	private IIntegrante dao;
	
	@Override
	@Transactional
	public void save(Integrante a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Integrante findById(Integer id) {
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
	public List<Integrante> findAll() {
		// TODO Auto-generated method stub
		return (List<Integrante> )dao.findAll();
	}
}
