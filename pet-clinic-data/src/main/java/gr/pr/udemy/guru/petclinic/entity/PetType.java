package gr.pr.udemy.guru.petclinic.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter()
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}
}
