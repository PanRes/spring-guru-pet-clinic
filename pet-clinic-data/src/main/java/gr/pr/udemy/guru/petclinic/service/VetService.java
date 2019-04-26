package gr.pr.udemy.guru.petclinic.service;

import gr.pr.udemy.guru.petclinic.entity.Vet;

import java.util.Set;

public interface VetService {

	Vet findById(int id);
	Set<Vet> findAll();
	Vet save();
}
