package com.valencia.ejercicio.models.entities;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artistas")
public class Artista implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_artista")
	public Integer idArtista;
	
	@Column(name="nombre_artistico")
	public String nombreArtistico;
	@Column(name="foto")
	public String foto;
	@Column(name="video")
	public String video;
	@Column(name="correo")
	public String correo;
	@Column(name="numero_telefonico")
	public String numeroTelefonico;
	@Column(name="costo")
	public float costo;
	@Column(name="link_facebook")
	public String linkFacebook;
	@Column(name="link_instagram")
	public String linkInstagram;
	@Column(name="link_twitter")
	public String linkTwitter;
	public Artista() {
		super();
	}
	
	public Artista(Integer id) {
		super();
		this.idArtista=id;
	}

	public Integer getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(String linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	public String getLinkInstagram() {
		return linkInstagram;
	}

	public void setLinkInstagram(String linkInstagram) {
		this.linkInstagram = linkInstagram;
	}

	
	//relaciones
	
	
	public String getLinkTwitter() {
		return linkTwitter;
	}

	public void setLinkTwitter(String linkTwitter) {
		this.linkTwitter = linkTwitter;
	}
	
	
	@JoinColumn(name="fk_genero",referencedColumnName="pk_genero")
	@ManyToOne
	private Genero genero;
	
	
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@JsonIgnore
	@OneToMany(mappedBy= "artista",fetch=FetchType.LAZY)
	private List<Evento> eventos;
	
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	@JsonIgnore
	@OneToMany(mappedBy="artista", fetch=FetchType.LAZY) 
	private List<Integrante> integrantes;
	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}	
	
	
}
