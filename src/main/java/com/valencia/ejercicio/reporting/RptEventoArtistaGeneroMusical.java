package com.valencia.ejercicio.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptEventoArtistaGeneroMusical implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String genero;
	private BigInteger artistas;
	private String evento;
	
	public RptEventoArtistaGeneroMusical(String genero, BigInteger artistas,String evento) {
		super();
		this.genero = genero;
		this.artistas = artistas;
		this.evento = evento;
	}

	public RptEventoArtistaGeneroMusical() {
		super();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public BigInteger getArtistas() {
		return artistas;
	}

	public void setArtistas(BigInteger artistas) {
		this.artistas = artistas;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	
	
	
	
	
}
