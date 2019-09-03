package gr.pr.udemy.guru.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	public PetType() {
	}

	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
