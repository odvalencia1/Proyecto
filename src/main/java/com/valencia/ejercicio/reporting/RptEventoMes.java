package com.valencia.ejercicio.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class RptEventoMes implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	private String mes;
	private BigInteger eventos;
	
	
	public RptEventoMes(String mes, BigInteger eventos) {
		super();
		this.mes = mes;
		this.eventos = eventos;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public BigInteger getEventos() {
		return eventos;
	}
	public void setEventos(BigInteger eventos) {
		this.eventos = eventos;
	}
	

}
