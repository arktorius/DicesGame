package com.game.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.app.entity.Gammer;
import com.game.app.model.MGammer;
import com.game.app.service.GammerService;

@RestController
@RequestMapping("/api/gammer")
public class GammerController {

	@Autowired
	@Qualifier("gammerService")
	private GammerService gammerService;

	@PostMapping
	public boolean createGammer(@RequestBody @Valid Gammer gammer) {
		System.out.println(gammer.getName());
		return gammerService.createGammer(new MGammer(gammer));

	}

	@GetMapping("/{id}")
	public MGammer getOneGammer(@PathVariable Long id) {

		return gammerService.getOneGammer(id);
	}
	@GetMapping("")
	public List<MGammer> getAllGammers(){
		return gammerService.allGammers();
	}
}
