package com.game.app.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.app.entity.Games;

@Repository("RepositoryGames")
public interface GamesRepository extends JpaRepository<Games, Serializable> {
	
	public abstract List<Games> findByGammerIdGammer(Long id);
	//public abstract void deleteByGammeridGammer(Long id);

}
