package gr.pr.udemy.guru.petclinic.service;

import java.util.Set;

public interface BaseCrudService<T, ID> {

	T findById(ID id);
	Set<T> findAll();
	T save(T object);
	Iterable<T> saveAll(Iterable<T> objects);
	void delete(T object);
	void deleteById(ID id);

}
