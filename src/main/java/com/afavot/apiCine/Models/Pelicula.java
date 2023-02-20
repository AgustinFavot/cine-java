package com.afavot.apiCine.Models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="peliculas")
@SuppressWarnings("unused")
public class Pelicula extends BaseEntity{

	private String titulo;

	private String resumen;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEstreno;
	
	private boolean enCines;	
	
	@ManyToMany
	private List<Actor> actores;
	
	@ManyToMany
	private List<Genero> generos;
	
	@PrePersist
	public void setFecha() {
		this.fechaEstreno = new Date();
	}
}
