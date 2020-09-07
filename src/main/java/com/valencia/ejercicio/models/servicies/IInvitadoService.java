package com.valencia.ejercicio.models.servicies;

import java.util.List;

import com.valencia.ejercicio.models.entities.Invitado;

public interface IInvitadoService {
	public void save(Invitado a);
	public Invitado findById(Integer id);
	public void delete(Integer id);
	public List<Invitado> findAll();
}
