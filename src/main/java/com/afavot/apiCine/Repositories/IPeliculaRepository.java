package com.afavot.apiCine.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.afavot.apiCine.Models.Pelicula;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {

}
