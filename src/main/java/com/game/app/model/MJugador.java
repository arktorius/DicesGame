package com.game.app.model;

import java.util.List;

import com.game.app.entity.Juego;
import com.game.app.entity.Jugador;

public class MJugador {
	
	private long id;
	private String name;
	private float statistics;
	/*private List<Juego> juego = new ArrayList<Juego>();*/
	public MJugador(long id, String name /*, List<Juego> juego*/) {
		this.id = id;
		this.name = name;
		
		/*this.juego = juego;*/

	}
	public MJugador(Jugador jugador) {
		this.id = jugador.getId();
		this.name = jugador.getName();
		this.statistics=jugador.getStatistics();
	}
	public MJugador() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getStatistics() {
		return statistics;
	}
	public void setStatistics(float statistics) {
		this.statistics = statistics;
	}
	
	
}