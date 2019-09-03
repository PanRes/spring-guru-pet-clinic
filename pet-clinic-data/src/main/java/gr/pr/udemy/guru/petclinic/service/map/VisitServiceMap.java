package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Visit;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	private final PetService petService;

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Iterable<Visit> saveAll(Iterable<Visit> visits) {
		return super.saveAll(visits);
	}

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() != null) {
			if (visit.getPet().getId() == null) {
				petService.save(visit.getPet());
			}

		}
		else {
			throw new RuntimeException("Pet is required");
		}

		return super.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		super.delete(visit);
	}
}
