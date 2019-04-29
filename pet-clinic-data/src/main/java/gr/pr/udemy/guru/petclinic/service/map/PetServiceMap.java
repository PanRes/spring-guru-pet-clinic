package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet owner) {
		super.delete(owner);
	}

	@Override
	public Pet save(Pet owner) {
		return super.save(owner.getId(), owner);
	}
}
