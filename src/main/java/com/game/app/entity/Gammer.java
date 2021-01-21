package com.game.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gammer {
	@Id
	@GeneratedValue
	private long idGammer;
	private String name;
	private float statistics;

	@OneToMany(mappedBy = "gammer", cascade = CascadeType.ALL)
	private List<Games> games = new ArrayList<Games>();

	public Gammer(String name) {

		this.name = name;
	}

	public long getIdGammer() {
		return idGammer;
	}

	public void setIdGammer(long idGammer) {
		this.idGammer = idGammer;
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

	public List<Games> getGames() {
		return games;
	}

	public void setGames(List<Games> games) {
		this.games = games;
	}

}
