package com.game.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Games {
	@Id
	@GeneratedValue
	private Long idGamme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGammer")
	private Gammer gammer;

	private int dice1 = (int) (Math.random() * 6 + 1);
	private int dice2 = (int) (Math.random() * 6 + 1);

	private String result;

	public Games(Long id) {

		this.gammer = new Gammer(id);
	}

	public Games() {

	}

	public Long getIdGamme() {
		return idGamme;
	}

	public void setIdGamme(Long idGamme) {
		this.idGamme = idGamme;
	}

	public Gammer getGammer() {
		return gammer;
	}

	public void setGammer(Gammer gammer) {
		this.gammer = gammer;
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

	@Override
	public String toString() {
		return "Games [idGamme=" + idGamme + ", gammer=" + gammer + ", dice1=" + dice1 + ", dice2=" + dice2
				+ ", result=" + result + "]";
	}

}
