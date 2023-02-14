package com.afavot.apiCine.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afavot.apiCine.Models.Pelicula;
import com.afavot.apiCine.Repositories.IPeliculaRepository;

@Service
public class PeliculaServiceImplement implements IPeliculaService {

	@Autowired
	private IPeliculaRepository peliculaRepository;
	
	@Override
	public void deleteById(Long id) {
		this.peliculaRepository.deleteById(id);
	}

	@Override
	public Iterable<Pelicula> findAll() {
		return this.peliculaRepository.findAll();
	}

	@Override
	public Pelicula findById(Long id) {
		return this.peliculaRepository.findById(id).orElse(null);
	}

	@Override
	public Pelicula save(Pelicula entity) {
		return this.peliculaRepository.save(entity);
	}
}
