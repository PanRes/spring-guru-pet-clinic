package gr.pr.udemy.guru.petclinic.service;

import gr.pr.udemy.guru.petclinic.entity.Pet;

import java.util.Set;

public interface PetService {

	Pet findById(int id);
	Set<Pet> findAll();
	Pet save();
}
