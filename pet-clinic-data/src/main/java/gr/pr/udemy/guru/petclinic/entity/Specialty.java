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
@Table(name = "specialty")
public class Specialty extends BaseEntity {

	@Column(name = "description")
	private String description;

}
