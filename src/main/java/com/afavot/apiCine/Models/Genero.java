package com.afavot.apiCine.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="generos")
@SuppressWarnings("unused")
public class Genero extends BaseEntity {
	
	private String nombre;
	
	@ManyToMany
	private List<Pelicula> peliculas;
}
