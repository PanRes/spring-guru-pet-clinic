package gr.pr.udemy.guru.petclinic.entity;

import java.time.LocalDate;

public class Pet extends BaseEntity {

	private String name;
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;

	public Pet() {
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
