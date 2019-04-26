package gr.pr.udemy.guru.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class BaseEntity implements Serializable {

	private Long id;

}
