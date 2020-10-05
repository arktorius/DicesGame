package com.game.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.app.entity.Jugador;

@Repository("Repositorio")
public interface JugadorRepository extends JpaRepository<Jugador, Serializable>{
	
	public abstract Jugador findById(long  id);
	public abstract List<Jugador> findAll();
}
