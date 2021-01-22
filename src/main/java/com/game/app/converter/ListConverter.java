package com.game.app.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.game.app.entity.Games;
import com.game.app.entity.Gammer;
import com.game.app.model.MGames;
import com.game.app.model.MGammer;

@Component("listConverter")
public class ListConverter {

	public List<MGammer> gammerConverter(List<Gammer> gammers) {
		List<MGammer> mGammers = new ArrayList<MGammer>();
		for (Gammer gammer : gammers) {
			mGammers.add(new MGammer(gammer));
		}

		return mGammers;
	}

	public List<MGames> gamesConverter(List<Games> games) {
		List<MGames> mGames = new ArrayList<MGames>();
		for (Games game : games) {
			mGames.add(new MGames(game));
		}

		return mGames;
	}

}
