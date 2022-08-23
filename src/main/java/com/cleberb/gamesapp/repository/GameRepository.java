package com.cleberb.gamesapp.repository;

import com.cleberb.gamesapp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
