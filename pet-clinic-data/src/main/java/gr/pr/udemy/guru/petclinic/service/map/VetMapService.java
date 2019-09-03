package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.SpecialtyService;
import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	@Override
	public Vet save(Vet vet) {
		if (vet != null){
			if (vet.getSpecialties() != null) {
				vet.getSpecialties().stream()
						.filter(specialty -> specialty.getId() == null)
						.forEach(specialtyService::save);
			}
			return super.save(vet);
		}
		else {
			return null;
		}
	}

	@Override
	public Iterable<Vet> saveAll(Iterable<Vet> vets) {
		return super.saveAll(vets);
	}
}
