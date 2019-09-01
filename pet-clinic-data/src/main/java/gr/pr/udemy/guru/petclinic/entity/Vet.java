package gr.pr.udemy.guru.petclinic.entity;

public class Vet extends Person {

	private Specialty specialty;

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
}
