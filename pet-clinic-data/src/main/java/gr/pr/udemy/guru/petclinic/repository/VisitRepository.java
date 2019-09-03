package gr.pr.udemy.guru.petclinic.repository;

import gr.pr.udemy.guru.petclinic.entity.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
