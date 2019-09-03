package gr.pr.udemy.guru.petclinic.repository;

import gr.pr.udemy.guru.petclinic.entity.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
