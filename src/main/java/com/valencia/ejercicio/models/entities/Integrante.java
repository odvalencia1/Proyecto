package com.valencia.ejercicio.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="integrantes")
public class Integrante extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name="foto")
	private String foto;
	
	
	public Integrante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integrante(Integer id) {
		super();
		this.setIdPersona(id);// TODO Auto-generated constructor stub
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	


	//relaciones

	@JoinColumn(name="fk_instrumento", referencedColumnName="pk_instrumento")
	@OneToOne
	private Instrumento instrumento;
	
	
	@JoinColumn(name="fk_artista",referencedColumnName="pk_artista")
	@ManyToOne
	private Artista artista;
	
	@Override
	public String toString() {
		return this.getNombre() + " " + this.getApellido();
	}
	
	
	
	
	
	
}
