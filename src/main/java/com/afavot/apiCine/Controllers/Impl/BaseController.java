package com.afavot.apiCine.Controllers.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.afavot.apiCine.Controllers.Generic.IControllerGeneric;
import com.afavot.apiCine.Models.BaseEntity;
import com.afavot.apiCine.Services.Generic.IGenericService;

@ResponseBody
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseController<T extends BaseEntity> implements IControllerGeneric<T>{
	
	@Autowired
	private IGenericService<T> serviceGeneric;
	
	private Map<String, Object> error = new HashMap<String, Object>();
	
	@Override
	@PostMapping()
	public ResponseEntity<?> post(T entity) {
		try {
			return new ResponseEntity(serviceGeneric.save(entity),HttpStatus.OK);
		} catch (DataAccessException ex) {
			error.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@GetMapping()
	public ResponseEntity<?> get() {
		try {
			return new ResponseEntity(serviceGeneric.findAll(),HttpStatus.OK);
		} catch (DataAccessException ex) {
			error.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(Long id) {
		try {
			return new ResponseEntity(serviceGeneric.findById(id),HttpStatus.OK);
		} catch (DataAccessException ex) {
			error.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(Long id) {
		try {
			serviceGeneric.deleteById(id);
			return new ResponseEntity("Success",HttpStatus.OK);
		} catch (DataAccessException ex) {
			error.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
