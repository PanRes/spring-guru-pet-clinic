package gr.pr.udemy.guru.petclinic.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne(optional = false)
	@JoinColumn(name = "owner_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Owner owner;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "pet", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Visit> visits = new HashSet<>();

	public Pet(String name, PetType petType, LocalDate birthDate) {
		this.name = name;
		this.petType = petType;
		this.birthDate = birthDate;
	}

	public Pet(String name, PetType petType, Owner owner, LocalDate birthDate) {
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}

}
