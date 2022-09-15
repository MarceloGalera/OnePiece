package br.com.anime.OnePiece.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Crew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameCrew;

	public Crew() {
		super();
	}

	public Crew(String nameCrew) {
		super();
		this.nameCrew = nameCrew;
	}

	public String getNameCrew() {
		return nameCrew;
	}

	public void setNameCrew(String nameCrew) {
		this.nameCrew = nameCrew;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameCrew);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crew other = (Crew) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameCrew, other.nameCrew);
	}

}
