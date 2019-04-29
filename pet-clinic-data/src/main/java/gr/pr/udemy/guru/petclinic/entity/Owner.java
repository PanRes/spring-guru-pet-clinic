package gr.pr.udemy.guru.petclinic.entity;

import lombok.Data;

@Data
public class Owner extends Person {

	public Owner(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Owner(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
}
