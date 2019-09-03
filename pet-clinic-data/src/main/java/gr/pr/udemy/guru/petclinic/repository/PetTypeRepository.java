package gr.pr.udemy.guru.petclinic.repository;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<Owner, Long> {
}
