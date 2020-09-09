package com.valencia.ejercicio.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptEventoArtista implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String artista;
	private BigInteger eventos;
	public RptEventoArtista(String artista, BigInteger eventos) {
		super();
		this.artista = artista;
		this.eventos = eventos;
	}
	public RptEventoArtista() {
		super();
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public BigInteger getEventos() {
		return eventos;
	}
	public void setEventos(BigInteger eventos) {
		this.eventos = eventos;
	}
	
	
	
	
	
}
