package gr.pr.udemy.guru.petclinic.service.springdatajpa;

import gr.pr.udemy.guru.petclinic.entity.Specialty;
import gr.pr.udemy.guru.petclinic.repository.SpecialtyRepository;
import gr.pr.udemy.guru.petclinic.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springDataJpa")
public class SpecialtySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Specialty> findAll() {

		Set<Specialty> specialties = new HashSet<>();

		specialtyRepository.findAll().forEach(specialties::add);

		return specialties;
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}

	@Override
	public void delete(Specialty specialty) {
		specialtyRepository.delete(specialty);
	}

	@Override
	public Specialty save(Specialty specialty) {
		return specialtyRepository.save(specialty);
	}

	@Override
	public Set<Specialty> saveAll(Iterable<Specialty> specialties) {
		Set<Specialty> specialtiesToReturn = new HashSet<>();

		specialtyRepository.saveAll(specialties).forEach(specialtiesToReturn::add);

		return specialtiesToReturn;
	}
}
