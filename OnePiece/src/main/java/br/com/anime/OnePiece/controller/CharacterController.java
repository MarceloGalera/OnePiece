package br.com.anime.OnePiece.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.anime.OnePiece.controller.form.CharacterForm;
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
	
	
//	@PostMapping
//	public void create(@RequestBody @Valid CharacterForm form) {
//		Character character = form.transform(characterRepository);
//		characterRepository.save(character);
//	}
	
	@PostMapping
	public ResponseEntity<CharacterDto> create(@RequestBody @Valid CharacterForm form, UriComponentsBuilder uriBuilder) {
		Character character = form.transform(characterRepository);
		characterRepository.save(character);
		
		URI uri = uriBuilder.path("/character/{id}").buildAndExpand(character.getId()).toUri();
		return ResponseEntity.created(uri).body(new CharacterDto(character));
	}
	

}
