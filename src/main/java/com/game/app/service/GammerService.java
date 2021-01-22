package com.game.app.service;

import java.util.List;

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
	@Qualifier("RepositoryGammer")
	private GammerRepository gammerRepository;
	@Autowired
	@Qualifier("RepositoryGames")
	private GamesRepository gameRepository;
	@Autowired
	@Qualifier("listConverter")
	private ListConverter converter;
	
	public boolean createGammer(MGammer newMGammer) {
	
		
		gammerRepository.save(new Gammer(newMGammer.getName()));
		
		return true;
		
	}
	public MGammer getOneGammer(Long id) {
		Gammer gammer = new Gammer();
		gammer = gammerRepository.findByIdGammer(id);
		MGammer oneGammer =new MGammer(gammer);
		System.out.println(oneGammer);
		return oneGammer;
	}
	
	public List<MGammer> allGammers(){
		List<MGammer> allGammers=converter.gammerConverter(gammerRepository.findAll());
		return allGammers;
	}
}
