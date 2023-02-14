package com.afavot.apiCine.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afavot.apiCine.Models.Actor;
import com.afavot.apiCine.Models.Pelicula;
import com.afavot.apiCine.Services.IPeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

	@Autowired
	private IPeliculaService peliculaService;
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Pelicula pelicula, @RequestBody Actor actor) {
		
		Pelicula peliculaNew = null;
		
		Map<String, Object> response = new HashMap<String, Object>();			
		
		try {
			peliculaNew = this.peliculaService.save(pelicula);
		} catch(DataAccessException ex) {	
			response.put("menssage", ex.getMessage().concat(" : ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<Pelicula>(peliculaNew, HttpStatus.CREATED);	
	}
}
