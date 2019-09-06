package gr.pr.udemy.guru.petclinic.service.springdatajpa;

import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.repository.VetRepository;
import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springDataJpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Vet> findAll() {

		Set<Vet> vets = new HashSet<>();

		vetRepository.findAll().forEach(vets::add);

		return vets;
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

	@Override
	public void delete(Vet vet) {
		vetRepository.delete(vet);
	}

	@Override
	public Vet save(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public Set<Vet> saveAll(Iterable<Vet> vets) {
		Set<Vet> vetsToReturn = new HashSet<>();

		vetRepository.saveAll(vets).forEach(vetsToReturn::add);

		return vetsToReturn;
	}
}
