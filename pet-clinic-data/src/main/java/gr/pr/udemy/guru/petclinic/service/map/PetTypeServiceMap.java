package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
	
	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(PetType petType) {
		super.delete(petType);
	}

	@Override
	public PetType save(PetType petType) {
		return super.save(petType);
	}
}