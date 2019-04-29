package gr.pr.udemy.guru.petclinic.entity;

import lombok.Data;

@Data
public class Vet extends Person {

	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Vet(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
}
