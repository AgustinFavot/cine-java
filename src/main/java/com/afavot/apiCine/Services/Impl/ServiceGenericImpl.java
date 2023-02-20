package com.afavot.apiCine.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.afavot.apiCine.Models.BaseEntity;
import com.afavot.apiCine.Repositories.Generic.IGenericRepository;
import com.afavot.apiCine.Services.Generic.IGenericService;

public class ServiceGenericImpl<T extends BaseEntity> implements IGenericService<T> {
	
	@Autowired
	protected IGenericRepository<T> genericRepository;
	
	@Override
	public T save(T entity) {
		try {
			return genericRepository.save(entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<T> findAll() {
		try {
			return genericRepository.findAll(); 
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public T findById(Long id) {
		try {
			return genericRepository.findById(id).orElse(null); 
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			genericRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}		
	}
}
