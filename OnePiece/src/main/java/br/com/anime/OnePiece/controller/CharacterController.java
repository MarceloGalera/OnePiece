package br.com.anime.OnePiece.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anime.OnePiece.dto.CharacterDto;
import br.com.anime.OnePiece.model.Character;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@GetMapping
	public List<CharacterDto> test() {
		
		Character character = new Character("Luffy", new BigDecimal(300000000), "Mugiwara");
		
		return CharacterDto.transform(Arrays.asList(character));

	}

}
