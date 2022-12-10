package me.dio.gameawards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.gameawards.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
