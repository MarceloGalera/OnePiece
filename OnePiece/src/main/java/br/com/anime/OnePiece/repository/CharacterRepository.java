package br.com.anime.OnePiece.repository;
import br.com.anime.OnePiece.model.Character;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
