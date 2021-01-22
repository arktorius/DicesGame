package com.game.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.app.model.MGames;
import com.game.app.service.GamesService;


@RestController
@RequestMapping("/api/games")
public class GamesController {
	@Autowired
	@Qualifier("gamesService")
	private GamesService gamesService;
	
	@GetMapping("/{id}")
	public MGames createGame(@PathVariable Long id) {
		return gamesService.createGame(id);
	}
}
