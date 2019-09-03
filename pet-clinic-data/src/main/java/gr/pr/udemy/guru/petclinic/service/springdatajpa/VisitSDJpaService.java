package gr.pr.udemy.guru.petclinic.service.springdatajpa;

import gr.pr.udemy.guru.petclinic.entity.Visit;
import gr.pr.udemy.guru.petclinic.repository.VisitRepository;
import gr.pr.udemy.guru.petclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

	private final VisitRepository visitRepository;

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();

		visitRepository.findAll().forEach(visits::add);

		return visits;
	}

	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}

	@Override
	public Iterable<Visit> saveAll(Iterable<Visit> visits) {
		Set<Visit> visitsToReturn = new HashSet<>();

		visitRepository.saveAll(visits).forEach(visitsToReturn::add);

		return visitsToReturn;

	}

	@Override
	public void delete(Visit visit) {
		visitRepository.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
}
