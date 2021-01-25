package com.game.app.model;

import com.game.app.entity.Games;

public class MGames {
	
	private Long idGamme;
	private int dice1;
	private int dice2;
	private String result;
	public MGames(Games game) {
		
		this.idGamme = game.getIdGamme();
		this.dice1 = game.getDice1();
		this.dice2 = game.getDice2();
		this.result = game.getResult();
	}
	public MGames() {
		
	}
	public Long getIdGamme() {
		return idGamme;
	}
	public void setIdGamme(Long idGamme) {
		this.idGamme = idGamme;
	}
	public int getDice1() {
		return dice1;
	}
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	public int getDice2() {
		return dice2;
	}
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
