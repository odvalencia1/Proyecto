package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.ICliente;
import com.valencia.ejercicio.models.entities.Cliente;

@Service
public class ClienteService implements IClienteService {
	@Autowired//Inyeccion de dependencia
	private ICliente dao;
	
	@Override
	@Transactional
	public void save(Cliente a) {
		dao.save(a);
		
	}

	@Override
	@Transactional
	public Cliente findById(Integer id) {
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
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente> )dao.findAll();
	}
}
