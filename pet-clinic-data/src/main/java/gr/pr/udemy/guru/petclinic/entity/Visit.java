package gr.pr.udemy.guru.petclinic.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter()
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity{

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "description")
	private String description;

	@ManyToOne(optional = false)
	@JoinColumn(name = "pet_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Pet pet;

}
