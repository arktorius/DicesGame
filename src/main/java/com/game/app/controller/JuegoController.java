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

import com.game.app.entity.Juego;
import com.game.app.entity.Jugador;
import com.game.app.model.MJuego;
import com.game.app.model.MJugador;
import com.game.app.service.JuegoService;
import com.game.app.service.JugadorService;

@RestController
@RequestMapping("/")
public class JuegoController {
	
	@Autowired
	@Qualifier("serviceJuego")
	JuegoService service;
	
	
	@PostMapping("/{jugador_id}/juego")
	public boolean agregarJuego(@PathVariable long jugador_id,@RequestBody @Valid Juego juego) {
	
	return service.crearJuego(juego,jugador_id);	
	
	}
	
	@GetMapping("/juego")
	public List<MJuego> obtenerJuegos(@PathVariable long jugador_id) {
		
		return service.obtenerJuegosDeUnJugador(jugador_id);
		
	}
	
	@GetMapping("/{id}/juego")
	public List<MJuego> obtenerUnjuego(@PathVariable long id){
		return service.obtenerUnJuego(id);
	}
	@DeleteMapping("/{id}/juego")
	public boolean borrarJuego(@PathVariable long id) {
		return service.borrarJuego(id);
	}
}