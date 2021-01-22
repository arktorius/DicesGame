package com.game.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.app.converter.ListConverter;
import com.game.app.entity.Games;
import com.game.app.entity.Gammer;
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

	public boolean createGame(Long id) {
		
		if(!gammerRepository.existsById(id)){return false;};
		
		Games game = new Games(id);
		// Set Result of game
		if ((game.getDice1() + game.getDice2()) == 7) {
			game.setResult("win");
		} else {
			game.setResult("looss");
		}
		
		gameRepository.save(game);
		// refresh gammer statistics
		Gammer gammer = gammerRepository.findByIdGammer(id);
		List<Games> allGames = gameRepository.findByGammerIdGammer(id);
		float counter = 0;
		
		for (Games gameResult : allGames) {
			if(gameResult.getResult().equalsIgnoreCase("win")) {
				counter++;
			}
		}
		
		if(counter>0) {
		float totalGames=allGames.size();
		
		gammer.setStatistics(counter/totalGames);
		
		gammerRepository.save(gammer);

		}
		return true;
	}
	public List<Games> getAllGames(){
		return gameRepository.findAll();
	}
}
