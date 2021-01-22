package com.game.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.app.entity.Gammer;

@Repository("RepositoryGammer")
public interface GammerRepository extends JpaRepository<Gammer, Serializable> {

	//public abstract Gammer save(Gammer gammer);
}
