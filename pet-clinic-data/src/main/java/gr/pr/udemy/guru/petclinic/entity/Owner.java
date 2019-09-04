package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "owner")
public class Owner extends Person {

	@Column(name = "address")
	private String address;

	@Column(name = "city", length = 50)
	private String city;

	@Column(name = "telephone", length = 15)
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

	public Owner(String firstName, String lastName, String address, String city, String telephone) {
		super(firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner(String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
		super(firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets;
	}

	@Builder
	public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		if (pets != null) {
			this.pets = pets;
		}
	}

	public void addPet(Pet pet) {
		this.pets.add(pet);
	}

	public void addPets(Set<Pet> pets) {
		this.pets.addAll(pets);
	}
}
