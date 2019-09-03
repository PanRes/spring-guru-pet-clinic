package gr.pr.udemy.guru.petclinic.service.springdatajpa.map;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.repository.OwnerRepository;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findFirstByLastName(lastName);
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Owner> findAll() {

		Set<Owner> owners = new HashSet<>();

		ownerRepository.findAll().forEach(owners::add);

		return owners;
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Set<Owner> saveAll(Iterable<Owner> owners) {
		Set<Owner> ownersToReturn = new HashSet<>();

		ownerRepository.findAll().forEach(ownersToReturn::add);

		return ownersToReturn;
	}
}
