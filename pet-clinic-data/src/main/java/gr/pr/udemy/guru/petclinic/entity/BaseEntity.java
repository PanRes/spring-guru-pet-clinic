package gr.pr.udemy.guru.petclinic.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}