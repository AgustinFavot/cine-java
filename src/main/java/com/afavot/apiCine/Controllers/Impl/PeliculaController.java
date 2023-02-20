package com.afavot.apiCine.Controllers.Impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afavot.apiCine.Models.Pelicula;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController extends BaseController<Pelicula>{

}
