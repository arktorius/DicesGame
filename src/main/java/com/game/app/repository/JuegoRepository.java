package com.game.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.app.entity.Juego;
import com.game.app.entity.Jugador;

@Repository("RepositorioJuego")
public interface JuegoRepository extends JpaRepository<Juego, Serializable>{

	public abstract List<Juego> findAll();
	public abstract List<Juego> findByJugadorId(long id);

	
	
	
	
}
