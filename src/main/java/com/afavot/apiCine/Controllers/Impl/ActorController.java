package com.afavot.apiCine.Controllers.Impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afavot.apiCine.Models.Actor;

@RestController()
@RequestMapping(path = "api/actores")
public class ActorController extends BaseController<Actor> {

}
