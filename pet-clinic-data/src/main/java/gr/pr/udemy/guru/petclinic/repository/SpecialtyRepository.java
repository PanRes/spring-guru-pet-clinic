package gr.pr.udemy.guru.petclinic.repository;

import gr.pr.udemy.guru.petclinic.entity.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
