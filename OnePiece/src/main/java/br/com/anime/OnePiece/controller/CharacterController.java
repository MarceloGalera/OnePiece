package br.com.anime.OnePiece.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anime.OnePiece.model.Character;
import br.com.anime.OnePiece.model.Crew;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@GetMapping
	public List<Character> test() {
		Crew crew1 = new Crew("Mugiwara");
		Crew crew2 = new Crew("Beasts Pirates");
		
		Character character = new Character("Luffy", new BigDecimal(1500000000), crew1);
		Character character2 = new Character("Zoro", new BigDecimal(300000000), crew1);
		Character character3 = new Character("Kaido", new BigDecimal(2000000000), crew2);
		
		return Arrays.asList(character, character2, character3);

	}

}
