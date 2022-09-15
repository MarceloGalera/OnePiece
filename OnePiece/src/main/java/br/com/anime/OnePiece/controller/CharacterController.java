package br.com.anime.OnePiece.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anime.OnePiece.dto.CharacterDto;
import br.com.anime.OnePiece.repository.CharacterRepository;
import br.com.anime.OnePiece.model.Character;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@GetMapping
	public List<CharacterDto> list() {
		
		List<Character> characters = characterRepository.findAll();
		
		return CharacterDto.transform(characters);

	}

}
