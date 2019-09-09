package gr.pr.udemy.guru.petclinic.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter()
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@Builder
	public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		if (visits != null && visits.size() > 0) {
			this.visits = visits;
		}
	}

	public Boolean isTheSamePet(Pet pet) {
		return (this.name == null && pet.getName() == null || this.name != null &&this.name.equalsIgnoreCase(pet.getName()))
				&& (this.petType == null && pet.getPetType() == null || this.petType != null && this.petType.equals(pet.getPetType()))
				&& (this.birthDate == null && pet.getBirthDate() == null || this.birthDate != null && this.birthDate.equals(pet.getBirthDate()));
	}

	public void addVisit(Visit visit) {
		visit.setPet(this);
		visits.add(visit);
	}

}
