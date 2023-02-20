package com.afavot.apiCine.Services.Generic;

import com.afavot.apiCine.Models.BaseEntity;

public interface IGenericService<T extends BaseEntity> {

	T save(T entity);
	
	Iterable<T> findAll();
	
	T findById(Long id);

	void deleteById(Long id);
}
