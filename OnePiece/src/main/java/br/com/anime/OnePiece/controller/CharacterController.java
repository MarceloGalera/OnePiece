package br.com.anime.OnePiece.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
								/* CREATE */
			
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
	
	
								/* READ */
	
	
	@GetMapping
	public List<CharacterDto> list() {
		List<Character> characters = characterRepository.findAll();
		return CharacterDto.transform(characters);
	}

	
	@GetMapping("/{id}")
	public CharacterDto listById(@PathVariable Long id) {
		Character referenceById = characterRepository.getReferenceById(id);
		return new CharacterDto(referenceById);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<CharacterDto> listById(@PathVariable Long id) {
//		Optional<Character> referenceById = characterRepository.findById(id);
//		if(referenceById.isPresent()) {
//			return ResponseEntity.ok(new CharacterDto(referenceById.get()));
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	
								/* UPDATE */
	
	@PutMapping("/{id}")
	@Transactional
	public CharacterDto update(@PathVariable Long id, @RequestBody @Valid CharacterForm form) {
		Character referenceById = form.update(id, characterRepository);
		return new CharacterDto(referenceById);
	}
	
	
								/* DELETE */
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		characterRepository.deleteById(id);
	}
	
}
