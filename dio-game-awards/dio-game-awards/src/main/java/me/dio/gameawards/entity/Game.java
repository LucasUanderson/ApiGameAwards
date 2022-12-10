package me.dio.gameawards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "games")
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY
    )
	private Long id;
	private String name;
	@Column(
		length = 500	
    )
	private String description;
	private String cover;
	private long votes;

}
