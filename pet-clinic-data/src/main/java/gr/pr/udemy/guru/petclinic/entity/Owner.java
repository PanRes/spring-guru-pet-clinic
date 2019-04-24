package gr.pr.udemy.guru.petclinic.entity;

import lombok.Data;

@Data
public class Owner extends Person {



	public Owner(String firstName, String lastName) {
		super(firstName, lastName);
	}
}
