package gr.pr.udemy.guru.petclinic.entity;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private Set<Specialty> specialties = new HashSet<>();

	public Vet() {
	}

	public Vet(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Vet(String firstName, String lastName, Set<Specialty> specialties) {
		super(firstName, lastName);
		this.specialties = specialties;
	}

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public void addSpecialty(Specialty specialty) {
		this.specialties.add(specialty);
	}

	public void addSpecialties(Set<Specialty> specialties) {
		this.specialties.addAll(specialties);
	}
}
