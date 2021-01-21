package com.game.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.app.converter.ListConverter;
import com.game.app.entity.Gammer;
import com.game.app.model.MGammer;
import com.game.app.repository.GamesRepository;
import com.game.app.repository.GammerRepository;

@Service("gammerService")
public class GammerService {
	@Autowired
	
	private GammerRepository gammerRepository;
	@Autowired

	private GamesRepository gameRepository;
	@Autowired
	
	private ListConverter converter;
	
	public boolean createGammer(MGammer newMGammer) {
		
		
		gammerRepository.save(new Gammer(newMGammer.getName()));
		
		return true;
		
	}
}
