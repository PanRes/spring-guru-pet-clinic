package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter()
@MappedSuperclass
public class Person extends BaseEntity {

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	Person(long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(Long id) {
		super(id);
	}
}
