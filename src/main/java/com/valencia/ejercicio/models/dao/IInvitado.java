package com.valencia.ejercicio.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.valencia.ejercicio.models.entities.Artista;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.entities.Invitado;

public interface IInvitado extends CrudRepository<Invitado, Integer>{
	public List<Invitado> findByEvento(Evento evento);
	public List<Invitado> findByArtistaInvitado(Artista artista);
}
