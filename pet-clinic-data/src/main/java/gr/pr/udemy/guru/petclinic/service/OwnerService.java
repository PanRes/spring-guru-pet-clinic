package gr.pr.udemy.guru.petclinic.service;

import gr.pr.udemy.guru.petclinic.entity.Owner;

import java.util.List;

public interface OwnerService extends BaseCrudService<Owner, Long>{

	Owner findByLastName(String lastName);

	List<Owner> findByLastNameLike(String lastName);

}
