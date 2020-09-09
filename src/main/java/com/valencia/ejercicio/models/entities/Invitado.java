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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="invitados")
public class Invitado  implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_invitado")	
	private Integer idInvitado;
	
	@JsonIgnore
	@JoinColumn(name="fk_artista", referencedColumnName="pk_artista")
	@ManyToOne
	private Artista artistaInvitado;
	
	@JsonIgnore
	@JoinColumn(name="fk_evento", referencedColumnName="pk_evento")
	@ManyToOne
	private Evento evento;
	
	@Column(name="tipo_pago", length=1)
	private String tipo_pago;
	
	public Invitado() {
		super();
	}

	public Invitado(Integer id) {
		super();
		this.idInvitado=id;
	}

	public Integer getIdInvitado() {
		return idInvitado;
	}

	public void setIdInvitado(Integer idInvitado) {
		this.idInvitado = idInvitado;
	}

	
	public Artista getArtistaInvitado() {
		return artistaInvitado;
	}

	public void setArtistaInvitado(Artista artistaInvitado) {
		this.artistaInvitado = artistaInvitado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}
	
	@Transient
	private int artistaid;
	
	@Transient
	private int eventoid;

	public int getArtistaid() {
		return artistaid;
	}

	public void setArtistaid(int artistaid) {
		this.artistaid = artistaid;
	}

	public int getEventoid() {
		return eventoid;
	}

	public void setEventoid(int eventoid) {
		this.eventoid = eventoid;
	}
	
	

}
