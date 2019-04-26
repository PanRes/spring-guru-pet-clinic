package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity {

	private String name;
}
