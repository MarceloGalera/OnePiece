package br.com.anime.OnePiece.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.anime.OnePiece.model.Character;
import br.com.anime.OnePiece.repository.CharacterRepository;

public class CharacterForm {

	@NotNull @NotEmpty @Length(min = 2, max = 25)
	private String name;
	
	@NotNull
	private BigDecimal bounty;
	
	@NotNull @NotEmpty @Length(min = 2, max = 50)
	private String crew;

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

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public Character transform(CharacterRepository characterRepository) {
		return new Character(name, bounty, crew);
	}

	public Character update(Long id, CharacterRepository characterRepository) {
		Character character = characterRepository.getReferenceById(id);
		
		character.setName(this.name);
		character.setBounty(this.bounty);
		character.setCrew(this.crew);
		
		return character;
	}	

}
