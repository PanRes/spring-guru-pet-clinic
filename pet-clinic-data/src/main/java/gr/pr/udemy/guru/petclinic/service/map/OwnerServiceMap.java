package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
		return super.save(owner.getId(), owner);
	}
}
