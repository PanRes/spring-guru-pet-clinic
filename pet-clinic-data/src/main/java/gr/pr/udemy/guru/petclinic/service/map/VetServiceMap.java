package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
	public void delete(Vet owner) {
		super.delete(owner);
	}

	@Override
	public Vet save(Vet owner) {
		return super.save(owner.getId(), owner);
	}
}