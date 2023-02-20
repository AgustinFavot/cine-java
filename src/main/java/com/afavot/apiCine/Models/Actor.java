package com.afavot.apiCine.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="actores")
public class Actor extends BaseEntity{

	private String nombre;
	
	private String apellido;
	
	@ManyToMany
	private List<Pelicula> peliculas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
