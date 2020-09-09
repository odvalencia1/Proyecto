package com.valencia.ejercicio.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instrumentos")
public class Instrumento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_instrumento")
	private Integer idInstrumento;
	
	@Column(name="nombre")
	private String nombre;
	
	public Instrumento(Integer idInstrumento, String nombre) {
		super();
		this.idInstrumento = idInstrumento;
		this.nombre = nombre;
		
	}

	public Instrumento() {
		super();
	}

	public Integer getIdInstrumento() {
		return idInstrumento;
	}

	public void setIdInstrumento(Integer idInstrumento) {
		this.idInstrumento = idInstrumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	


	
}
