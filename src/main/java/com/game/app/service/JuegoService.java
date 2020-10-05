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
import com.game.app.model.MJuego;
import com.game.app.model.MJugador;
import com.game.app.repository.JuegoRepository;
import com.game.app.repository.JugadorRepository;

@Service("serviceJuego")
public class JuegoService {

	private static final Log looger=LogFactory.getLog(JugadorService.class);
	
	@Autowired
	@Qualifier("RepositorioJuego")
	private JuegoRepository repositorio;
	
	@Autowired
	@Qualifier("Repositorio")
	private JugadorRepository repositorioJugador;
	
	@Autowired
	@Qualifier("Convertidor")
	private Convertidor convertidor;
	
	public boolean crearJuego(Juego juego,long id) {
		looger.info("CREANDO JUEGO");
		try {
			/*Asignando Id de jugador al juego*/
			juego=new Juego(id);
			String resultado=juego.getResultado();
			juego.setResultado(resultado);
			
			/*actualizando la estadistica del jugador*/
			Jugador jugador=repositorioJugador.findById(id);
			float contador=0;
			List<Juego> juegos=repositorio.findByJugadorId(id);
			
			for(Juego juego1: juegos) {
				if(juego1.getResultado().equals("gana")) {
					contador++;
				}
			}
			
			contador=(float) (contador*100.00);
			
			
			jugador.setStatistics((float)contador/juegos.size());
			
			
			
			
			repositorio.save(juego);
			looger.info("JUEGO CREADO");
			return true;
			
		}catch(Exception e) {
			looger.info("FALLO EN CREAR JUEGO");
			return false;
			
		}
		
	}
	
	public List<MJuego> obtenerJuegosDeUnJugador( long jugador_id){
		
		return convertidor.convertirListaJuego(repositorio.findAll()) ;
	
	}

	public List<MJuego> obtenerUnJuego(long jugador_id){
	
	return convertidor.convertirListaJuego(repositorio.findByJugadorId(jugador_id)) ;
	}
	
	public boolean borrarJuego(long id) {
		
		repositorio.deleteById(id);
		
		return true;
	}







}