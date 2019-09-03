package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

}
