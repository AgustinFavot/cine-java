package com.afavot.apiCine.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afavot.apiCine.Models.Actor;
import com.afavot.apiCine.Repositories.IActorRepository;

@Service
public class ActorServiceImplement implements IActorService {

	@Autowired
	private IActorRepository actorRepository;
	
	@Override
	public void deleteById(Long id) {
		this.actorRepository.deleteById(id);
	}

	@Override
	public Iterable<Actor> findAll() {
		return this.actorRepository.findAll();
	}

	@Override
	public Actor findById(Long id) {
		return this.actorRepository.findById(id).orElse(null);
	}

	@Override
	public Actor save(Actor entity) {
		return this.actorRepository.save(entity);
	}
}
