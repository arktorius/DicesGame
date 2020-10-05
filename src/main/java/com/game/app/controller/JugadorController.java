package com.game.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.app.entity.Jugador;
import com.game.app.model.MJugador;
import com.game.app.service.JugadorService;

@RestController
@RequestMapping("/")
public class JugadorController {
	
	
	@Autowired
	@Qualifier("service")
	JugadorService service;
	
	@PutMapping("/jugador")
	public boolean agregarJugador(@RequestBody @Valid Jugador jugador) {
		
	return service.crear(jugador);	
	}
	@PostMapping("/jugador")
	public boolean actualizarJugador(@RequestBody @Valid Jugador jugador) {
		
	return service.actualizar(jugador);	
	}
	
	
	@DeleteMapping("/jugador/{id}")
	public boolean borrarJugador(@PathVariable("id" )long id) {
	
		return service.borrarJugador(id);
	}
	@GetMapping("/jugador")
	public List<MJugador> obtenerJugadores() {
		
		return service.obtener();
		
	}
	
	@GetMapping("/rankingDecreciente")
	public List<MJugador> rankingDecreciente(){
		
		return service.obtenerRankingDecreciente();
	}
	@GetMapping("/rankingCreciente")
	public List<MJugador> rankingCreciente(){
		
		return service.obtenerRankingDecreciente();
	}

}
