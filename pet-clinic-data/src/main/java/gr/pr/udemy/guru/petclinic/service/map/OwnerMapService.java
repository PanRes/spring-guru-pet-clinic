package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetService petService;

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream()
				.filter(owner -> owner.getLastName().equals(lastName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public Owner save(Owner owner) {
		if (owner != null) {
			if (owner.getPets() != null) {
				owner.getPets().stream()
						.filter(pet -> pet.getId() == null)
						.forEach(pet -> {
							if (!owner.equals(pet.getOwner())) {
								pet.setOwner(owner);
							}
							petService.save(pet);
						});
			}
			return super.save(owner);
		}
		else {
			return null;
		}
	}

	@Override
	public Iterable<Owner> saveAll(Iterable<Owner> owners) {
		return super.saveAll(owners);
	}
}
