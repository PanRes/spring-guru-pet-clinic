package gr.pr.udemy.guru.petclinic.service;

import gr.pr.udemy.guru.petclinic.entity.Owner;

import java.util.Set;

public interface OwnerService {

	Owner findById(int id);
	Set<Owner> findAll();
	Owner save();
}
