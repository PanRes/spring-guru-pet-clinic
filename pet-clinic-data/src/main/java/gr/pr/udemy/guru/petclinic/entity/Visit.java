package gr.pr.udemy.guru.petclinic.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visit")
public class Visit extends BaseEntity{

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "description")
	private String description;

	@ManyToOne(optional = false)
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Visit() {
	}

	public Visit(LocalDate date, String description, Pet pet) {
		this.date = date;
		this.description = description;
		this.pet = pet;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
