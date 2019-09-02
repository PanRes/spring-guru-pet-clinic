package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	private final PetTypeService petTypeService;

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
	public void delete(Pet pet) {
		super.delete(pet);
	}

	@Override
	public Pet save(Pet pet) {
		if (pet != null){
			if (pet.getPetType() != null) {
				if (pet.getPetType().getId() == null) {
					petTypeService.save(pet.getPetType());
				}
			}
			else {
				throw new RuntimeException("Pet Type is required");
			}

			return super.save(pet);
		}
		else {
			return null;
		}
	}

	@Override
	public Iterable<Pet> saveAll(Iterable<Pet> pets) {
		return super.saveAll(pets);
	}
}
