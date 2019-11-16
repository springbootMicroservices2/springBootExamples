package com.example.springboot.data.jpa.demo.springbootjpademo3.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
@NamedNativeQuery(name = "CityEntity.findAllOrderedByNameDescending", query = "SELECT * FROM CITIES  order by name desc", resultClass = CityEntity.class)
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private int population;

	public CityEntity() {
	}

	public CityEntity(String name, int population) {
		this.name = name;
		this.population = population;
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		hash = 79 * hash + Objects.hashCode(this.name);
		hash = 79 * hash + this.population;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CityEntity other = (CityEntity) obj;
		if (this.population != other.population) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("City{id=").append(id).append(", name=").append(name).append(", population=").append(population)
				.append("}");

		return builder.toString();
	}
}