package com.afavot.apiCine.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afavot.apiCine.Models.Actor;
import com.afavot.apiCine.Services.IActorService;

@RestController()
@RequestMapping("api/actores")
public class ActorController {

	@Autowired
	private IActorService service;	
	
	@GetMapping()
	public ResponseEntity<?> getAll()
	{
		Map<String, Object> response = new HashMap<String, Object>();
		try 
		{
			return new ResponseEntity<Iterable<Actor>>(this.service.findAll(), HttpStatus.OK);
		}
		catch(DataAccessException ex)
		{
			response.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Actor actor, BindingResult result)
	{
		Actor actorResponse = null;
		Map<String, Object> response = new HashMap<String, Object>();
		
		try 
		{
			actorResponse = this.service.save(actor);
			return new ResponseEntity<Actor>(actorResponse, HttpStatus.OK);
		} catch(DataAccessException ex)
		{
			response.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
