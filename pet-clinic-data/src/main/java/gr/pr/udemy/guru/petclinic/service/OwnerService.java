package gr.pr.udemy.guru.petclinic.service;

import gr.pr.udemy.guru.petclinic.entity.Owner;

public interface OwnerService extends BaseCrudService<Owner, Long>{

	Owner findByLastName(String lastName);
}
