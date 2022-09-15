package br.com.anime.OnePiece.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String crew;
	private BigDecimal bounty;

	public Character(Long id, String name, String crew, BigDecimal bounty) {
		this.id = id;
		this.name = name;
		this.crew = crew;
		this.bounty = bounty;
	}

	public Character() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public BigDecimal getBounty() {
		return bounty;
	}

	public void setBounty(BigDecimal bounty) {
		this.bounty = bounty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bounty, crew, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(bounty, other.bounty) && Objects.equals(crew, other.crew) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

}