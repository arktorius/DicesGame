package com.game.app.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.app.converter.Convertidor;
import com.game.app.entity.Juego;
import com.game.app.entity.Jugador;
import com.game.app.model.MJugador;
import com.game.app.repository.JuegoRepository;
import com.game.app.repository.JugadorRepository;

@Service("service")
public class JugadorService {
	
	private static final Log looger=LogFactory.getLog(JugadorService.class);
	
	@Autowired
	@Qualifier("Repositorio")
	private JugadorRepository repositorio;
	
	@Autowired
	@Qualifier("RepositorioJuego")
	private JuegoRepository repositorioJuego;
	
	@Autowired
	@Qualifier("Convertidor")
	private Convertidor convertidor;
	
	
	public boolean crear(Jugador jugador) {
		looger.info("CREANDO JUGADOR");
		try {
			if(jugador.getName()=="") {
				jugador.setName("ANONIMO");
			}
			
		
			
			repositorio.save(jugador);
			
			looger.info("JUGADOR CREADO");
			return true;
		}catch(Exception e) {
		looger.error("ALGO SALIO MAL AL CREAR");	
			return false;
		}
		
	}
	
	public boolean actualizar(Jugador jugador) {
		try {
			repositorio.save(jugador);
			return true;
		}catch(Exception e) {
			
			return false;
		}
		
	}
	
	public boolean borrarJugador(long id) {
		try {
			Jugador jugador = repositorio.findById(id);
			
			repositorio.delete(jugador);
			return true;
		}catch(Exception e) {
			
			return false;
		}
		
	}
	
	public List<MJugador> obtener(){
		
		return convertidor.convertirLista(repositorio.findAll()) ;/*leer este ultimo metodo*/
	}
	public MJugador obtenerPorId(String name, long id) {
		return new MJugador(repositorio.findById(id));
		
		
	}
	
	public List<MJugador> obtenerRankingDecreciente(){
		Jugador pivote1;
		Jugador pivote2;
		List<Jugador> ranking=repositorio.findAll();
		
		
		for(int j=0; j<ranking.size();j++) {
		for(int i=1; i<ranking.size();i++) {
			if(ranking.get(j).getStatistics()   >	ranking.get(i).getStatistics()) {
			pivote1 = ranking.get(j);
			pivote2 = ranking.get(i);
			
			ranking.set(i,pivote1);
			ranking.set(j,pivote2);
			}
		}
		}
		
		return  convertidor.convertirLista(ranking) ;
	}
	
	public List<MJugador> obtenerRankingCreciente(){
		Jugador pivote1;
		Jugador pivote2;
		List<Jugador> ranking=repositorio.findAll();
		
		
		for(int j=0; j<ranking.size();j++) {
		for(int i=1; i<ranking.size();i++) {
			if(ranking.get(j).getStatistics()   <	ranking.get(i).getStatistics()) {
			pivote1 = ranking.get(j);
			pivote2 = ranking.get(i);
			
			ranking.set(i,pivote1);
			ranking.set(j,pivote2);
			}
		}
		}
		
		return  convertidor.convertirLista(ranking) ;
	}
	

}
