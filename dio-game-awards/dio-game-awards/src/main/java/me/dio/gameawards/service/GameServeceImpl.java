package me.dio.gameawards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import exception.BusinessException;
import exception.NoContentException;
import me.dio.gameawards.entity.Game;
import me.dio.gameawards.repository.GameRepository;


@Service
public class GameServeceImpl implements GameService {
	
	
	private GameRepository repository;
	
	public GameServeceImpl(GameRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Game> findAll() {
		List<Game> games = repository.findAll(Sort.by(Direction.DESC,"votes"));
		return games;
	}

	@Override
	public Game findById(Long id) {
	Optional<Game> game = repository.findById(id);
	return game.orElseThrow(() -> new NoContentException());
	}

	@Override
	public Game insert(Game game) {
		Game saveGame = repository.save(game);
		return saveGame;
	}

	@Override
	public Game update(Long id, Game game) {
		Game gameDb = findById(id);
		if (gameDb.getId().equals(game.getId())) {
			repository.save(game);
		} else {
			throw new BusinessException("Id não encontrado insira um id valido");
		}
		
		return gameDb;

	}

	@Override
	public void delete(Long id) {
		Game gameDb = findById(id);
		repository.delete(gameDb);
		
	}

	@Override
	public void vote(Long id) {
		Game gameDb = findById(id);
		gameDb.setVotes(gameDb.getVotes() + 1);
		update(id, gameDb);
	}

}
