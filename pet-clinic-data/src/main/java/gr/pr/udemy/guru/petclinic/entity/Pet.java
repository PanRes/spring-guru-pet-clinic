package gr.pr.udemy.guru.petclinic.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne(optional = false)
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	public Pet() {
	}

	public Pet(String name, PetType petType, LocalDate birthDate) {
		this.name = name;
		this.petType = petType;
		this.birthDate = birthDate;
	}

	public Pet(String name, PetType petType, Owner owner, LocalDate birthDate) {
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetType getPetType() {
		return this.petType;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
