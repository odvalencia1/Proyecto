package com.valencia.ejercicio.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@DateTimeFormat(pattern = "HH:mm")	
	@Column(name="hora_inicio")
	private Date horaInicio;
	

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	@Column(name="hora_fin")
	private Date horaFin;
	
	@NotEmpty
	@Size(max=20)
	@Column(name="nombre")
	private String nombre;
	@NotEmpty
	@Size(max=20)
	@Column(name="lugar")
	private String lugar;

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

	//relación
	
	
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy="evento", fetch=FetchType.LAZY) 
	private List<Invitado> invitados;

	public List<Invitado> getInvitados() {
		if(invitados==null)
			invitados= new ArrayList<Invitado>();
		return invitados;
	}

	public void setInvitados(List<Invitado> invitados) {
		this.invitados = invitados;
	}
	
	
}
