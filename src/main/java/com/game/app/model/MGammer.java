package com.game.app.model;

import com.game.app.entity.Gammer;

public class MGammer {
	
	private Long idMGamer;
	private String name;
	private float statistics;
	
	
	public MGammer(Gammer gammer) {
		
		this.idMGamer = gammer.getIdGammer();
		this.name = gammer.getName();
		this.statistics = gammer.getStatistics();
	}
	
	public MGammer() {

	}

	public Long getIdMGamer() {
		return idMGamer;
	}
	public void setIdMGamer(Long idMGamer) {
		this.idMGamer = idMGamer;
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
