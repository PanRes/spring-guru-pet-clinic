package gr.pr.udemy.guru.petclinic.entity;

public class PetType extends BaseEntity {

	private String name;

	public PetType() {
	}

	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
