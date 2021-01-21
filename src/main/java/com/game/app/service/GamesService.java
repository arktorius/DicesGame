package com.game.app.service;

import org.springframework.stereotype.Service;

import com.game.app.converter.ListConverter;
import com.game.app.repository.GamesRepository;
import com.game.app.repository.GammerRepository;

@Service("gamesService")
public class GamesService {

	private GammerRepository gammerRepository;
	private GamesRepository gameRepository;
	private ListConverter converter;
	
	
}
