package com.game.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Juego implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="jugadorId")
	private Jugador jugador;
	
	private int dado1 = (int) (Math.random()*7 + 1) ;
	private int dado2 = (int) (Math.random()*7 + 1) ;
	private String resultado;
	public Juego(long id) {
		this.jugador=new Jugador(id);
	}
	public Juego() {
		super();
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
		String result="pierde";
		if((this.dado1+this.dado2)==7) {
			result="gana";
		}
		return result;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "Juego [id=" + id + ", dado1=" + dado1 + ", dado2=" + dado2 + ", resultado=" + resultado + "]";
	}
	
	
	
	
	

}
