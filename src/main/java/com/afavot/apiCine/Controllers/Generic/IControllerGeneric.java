package com.afavot.apiCine.Controllers.Generic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.afavot.apiCine.Models.BaseEntity;

@SuppressWarnings("hiding")
public interface IControllerGeneric <T extends BaseEntity>{

	ResponseEntity<?> post(@RequestBody T entity);
	
	ResponseEntity<?> get();
	
	ResponseEntity<?> get(@PathVariable(name="id") Long id);
	
	ResponseEntity<?> delete(@PathVariable(name="id") Long id);
}
