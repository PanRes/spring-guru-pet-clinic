package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseEntity {

	private PetType petType;

	private Owner owner;

	private LocalDate birthDate;

	public Pet(Long id, PetType petType, Owner owner, LocalDate birthDate) {
		super(id);
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}
}
