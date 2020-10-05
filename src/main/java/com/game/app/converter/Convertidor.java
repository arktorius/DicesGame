package com.game.app.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.game.app.entity.Juego;
import com.game.app.entity.Jugador;
import com.game.app.model.MJuego;
import com.game.app.model.MJugador;

@Component("Convertidor")
public class Convertidor {
	public List<MJugador> convertirLista(List<Jugador> jugadores){
		
		List<MJugador> mjugadores = new ArrayList<>();
		
		
		for(Jugador jugador : jugadores) {
			mjugadores.add(new MJugador(jugador));
		}
		
		return mjugadores;
	}/* Releer el codigo*/
	
	public List<MJuego> convertirListaJuego(List<Juego> juegos){
		
		List<MJuego> mjuegos = new ArrayList<>();
		
		
		for(Juego juego : juegos) {
			mjuegos.add(new MJuego(juego));
		}
		
		return mjuegos;
	}/* Releer el codigo*/
}
