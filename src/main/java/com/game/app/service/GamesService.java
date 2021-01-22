package com.game.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.app.converter.ListConverter;
import com.game.app.entity.Games;
import com.game.app.model.MGames;
import com.game.app.repository.GamesRepository;
import com.game.app.repository.GammerRepository;

@Service("gamesService")
public class GamesService {
	@Autowired
	@Qualifier("RepositoryGammer")
	private GammerRepository gammerRepository;
	@Autowired
	@Qualifier("RepositoryGames")
	private GamesRepository gameRepository;
	@Autowired
	@Qualifier("listConverter")
	private ListConverter converter;
	
	public MGames createGame(Long id) {
		
		Games game= new Games(id);
		if((game.getDice1()+game.getDice2())==7) {
			game.setResult("win");
		}else {
			game.setResult("looss");
		}
		System.out.println(game.toString());
		gameRepository.save(game);
		return null;
	}
}
