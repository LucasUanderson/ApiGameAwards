package me.dio.gameawards.controller.game;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.controller.BaseRestController;
import me.dio.gameawards.entity.Game;
import me.dio.gameawards.service.GameService;

@CrossOrigin
@RestController
public class GameRestController extends BaseRestController {
	
    private final GameService businessLayer;
	
	public GameRestController(GameService businessLayer) {
		this.businessLayer = businessLayer;
	}
	
	@GetMapping("games")
	public ResponseEntity <List<Game>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(businessLayer.findAll());
	}
	
	@GetMapping("games/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(businessLayer.findById(id));
	}
	
	@PostMapping("games")
	public ResponseEntity<Game> insert(@RequestBody Game game){
		return ResponseEntity.status(HttpStatus.OK).body(businessLayer.insert(game));
	}
	
	@PutMapping("games/{id}")
	public ResponseEntity<Game> update( @PathVariable Long id, @RequestBody Game game){
		return ResponseEntity.status(HttpStatus.CREATED).body(businessLayer.update(id, game));
	}
	
	@DeleteMapping("games/{id}")
	public ResponseEntity<Game> delete(@PathVariable Long id){
		businessLayer.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping("games/{id}/vote")
	public ResponseEntity<Game> update( @PathVariable Long id){
		businessLayer.vote(id);
		return ResponseEntity.status(HttpStatus.OK).build();

	}
	
	
	

}
