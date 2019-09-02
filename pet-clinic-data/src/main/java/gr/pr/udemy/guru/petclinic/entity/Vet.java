package gr.pr.udemy.guru.petclinic.entity;

public class Vet extends Person {

	private Specialty specialty;

	public Vet() {
	}

	public Vet(Specialty specialty) {
		this.specialty = specialty;
	}

	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Vet(String firstName, String lastName, Specialty specialty) {
		super(firstName, lastName);
		this.specialty = specialty;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
}
