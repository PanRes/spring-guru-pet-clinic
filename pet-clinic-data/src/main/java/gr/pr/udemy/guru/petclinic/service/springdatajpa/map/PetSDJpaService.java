package gr.pr.udemy.guru.petclinic.service.springdatajpa.map;

import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.repository.PetRepository;
import gr.pr.udemy.guru.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Pet> findAll() {

		Set<Pet> pets = new HashSet<>();

		petRepository.findAll().forEach(pets::add);

		return pets;
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

	@Override
	public void delete(Pet pet) {
		petRepository.delete(pet);
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Set<Pet> saveAll(Iterable<Pet> pets) {
		Set<Pet> petsToReturn = new HashSet<>();

		petRepository.saveAll(pets).forEach(petsToReturn::add);

		return petsToReturn;
	}
}
