package br.com.anime.OnePiece.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.anime.OnePiece.model.Character;

public class CharacterDto {

	private Long id;
	private String name;
	private BigDecimal bounty;
	private String crew;

	public CharacterDto(Character character) {
		this.id = character.getId();
		this.name = character.getName();
		this.bounty = character.getBounty();
		this.crew = character.getCrew();
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBounty() {
		return bounty;
	}

	public void setBounty(BigDecimal bounty) {
		this.bounty = bounty;
	}

	public static List<CharacterDto> transform(List<Character> asList) {
		return asList.stream().map(CharacterDto::new).collect(Collectors.toList());
	}

}
