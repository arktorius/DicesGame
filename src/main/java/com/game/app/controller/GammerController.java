package com.game.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
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
	public boolean createGammer(@RequestBody Gammer gammer) {
		System.out.println(gammer);
		return gammerService.createGammer(new MGammer(gammer));

	}

	@GetMapping("")
	public boolean test() {
		return true;
	}
}
