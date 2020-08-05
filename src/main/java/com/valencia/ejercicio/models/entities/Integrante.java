package com.valencia.ejercicio.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	//relaciones
	@JoinColumn(name="fk_artista",referencedColumnName="pk_artista")
	@ManyToOne
	private Artista artista;
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
}
