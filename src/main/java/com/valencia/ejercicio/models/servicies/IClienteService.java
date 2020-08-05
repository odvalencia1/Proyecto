package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Cliente;

public interface IClienteService {
	public void save(Cliente a);
	public Cliente findById(Integer id);
	public void delete(Integer id);
	public List<Cliente> findAll();
}
