package com.valencia.ejercicio.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="eventos")
public class Evento implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_evento")
	private Integer idEvento;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar fecha;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm:ss")
	@Column(name="hora_inicio")
	private Date horaInicio;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm:ss")
	@Column(name="hora_fin")
	private Date horaFin;
	@Column(name="nombre")
	private String nombre;
	@Column(name="lugar")
	private String lugar;
	@Column(name="pago")
	private String pago;

	public Evento() {
		super();
	}
	
	public Evento(Integer id) {
		super();
		this.idEvento=id;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}
	
	//relación
	@JoinColumn(name="fk_artista",referencedColumnName="pk_artista")
	@ManyToOne
	private Artista artista;
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	@JoinColumn(name="fk_cliente",referencedColumnName="pk_persona")
	@ManyToOne
	private Cliente cliente;
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String fechaEve() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(this.fecha.getTime());
	}
	public String horaIn() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(this.horaInicio.getTime());
	}
	public String horaFin() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(this.horaFin.getTime());
	}
	@JoinColumn(name="fk_estado",referencedColumnName="pk_estado")
	@ManyToOne
	private TipoEstado estado;

	public TipoEstado getEstado() {
		return estado;
	}

	public void setEstado(TipoEstado estado) {
		this.estado = estado;
	}
	
	
	
}
