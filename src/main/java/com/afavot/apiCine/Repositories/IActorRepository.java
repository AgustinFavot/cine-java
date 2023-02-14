package com.afavot.apiCine.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.afavot.apiCine.Models.Actor;

public interface IActorRepository extends CrudRepository<Actor, Long> {

}
