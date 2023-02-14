package com.afavot.apiCine.Services;

public interface IGenericService<T, ID> {

	void deleteById(ID id);
	
	Iterable<T> findAll();
	
	T findById(ID id);
	
	T save(T entity);
}
