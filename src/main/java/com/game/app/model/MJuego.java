package com.game.app.model;

import com.game.app.entity.Juego;

public class MJuego {
	
	private long id;
	private int dado1;
	private int dado2;
	private String resultado;
	public MJuego(Juego juego) {
		this.id = juego.getId();
		this.dado1 = juego.getDado1();
		this.dado2 = juego.getDado2();
		this.resultado = juego.getResultado();
	}
	public MJuego() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDado1() {
		return dado1;
	}
	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}
	public int getDado2() {
		return dado2;
	}
	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	

}
