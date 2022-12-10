package me.dio.gameawards.service;

import java.util.List;

import me.dio.gameawards.entity.Game;


public interface GameService {
	
	List<Game> findAll();
	
	Game findById(Long id);
	
	Game insert(Game game);
	
	Game update(Long id, Game game);

	void delete(Long id);

    void vote(Long id);

}
