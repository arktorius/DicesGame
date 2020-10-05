package com.game.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Jugador implements Serializable{
	
	
	@Id
	
	@GeneratedValue
	@Column(name="jugadorId")
	private long id;
	private String name;
	private float statistics;
	@Transient
	float contador=0;
	@OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
	private List<Juego> juego = new ArrayList<Juego>();
	
	public Jugador(long id) {
		this.id=id;
	for(Juego juego: this.juego ) {
		
		if(juego.getResultado().contentEquals("gana")) {
		contador++;	
		}
		}
	this.statistics=(float)(contador/(juego.size()));
		
	}
	public Jugador() {
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
	public List<Juego> getJuego() {
		return juego;
	}
	public void setJuego(List<Juego> juego) {
		this.juego = juego;
	}
	public float getStatistics() {
		return statistics;
	}
	public void setStatistics(float statistics) {
		this.statistics = statistics;
	}

	
	
}
