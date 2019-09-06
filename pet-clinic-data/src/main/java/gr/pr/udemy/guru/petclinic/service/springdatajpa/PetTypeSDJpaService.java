package gr.pr.udemy.guru.petclinic.service.springdatajpa;

import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.repository.PetTypeRepository;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springDataJpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {

		Set<PetType> petTypes = new HashSet<>();

		petTypeRepository.findAll().forEach(petTypes::add);

		return petTypes;
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

	@Override
	public void delete(PetType pet) {
		petTypeRepository.delete(pet);
	}

	@Override
	public PetType save(PetType pet) {
		return petTypeRepository.save(pet);
	}

	@Override
	public Set<PetType> saveAll(Iterable<PetType> petTypes) {
		Set<PetType> petsToReturn = new HashSet<>();

		petTypeRepository.saveAll(petTypes).forEach(petsToReturn::add);

		return petsToReturn;
	}
}
