package gr.pr.udemy.guru.petclinic.entity;

public class Specialty extends BaseEntity {

	private String description;

	public Specialty() {
	}

	public Specialty(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
