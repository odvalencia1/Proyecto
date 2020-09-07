package com.valencia.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Invitado;

public interface IInvitado extends CrudRepository<Invitado, Integer>{
	
}
