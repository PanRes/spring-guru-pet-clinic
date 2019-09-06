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
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

}
