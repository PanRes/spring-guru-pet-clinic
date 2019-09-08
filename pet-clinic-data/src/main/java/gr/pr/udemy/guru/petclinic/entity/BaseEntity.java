package gr.pr.udemy.guru.petclinic.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter()
@ToString(callSuper = true)
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public boolean isNew() {
		return this.id == null;
	}
}
