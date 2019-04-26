package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person extends BaseEntity {

	private String firstName;

	private String lastName;

}
