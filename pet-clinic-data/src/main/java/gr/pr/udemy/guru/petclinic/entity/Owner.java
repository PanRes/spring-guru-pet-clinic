package gr.pr.udemy.guru.petclinic.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

	public Owner() {
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public void addPet(Pet pet) {
		this.pets.add(pet);
	}

	public void addPets(Set<Pet> pets) {
		this.pets.addAll(pets);
	}
}
