package com.valencia.ejercicio.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="clientes")

public class Cliente extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id) {
		super();
		this.setIdPersona(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		 return super.toString();
	 }
	//realación
	@OneToMany(mappedBy= "cliente",fetch=FetchType.LAZY)
	private List<Evento> eventos;
}
