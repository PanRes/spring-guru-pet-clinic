package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

	public static final Long OWNER_ID = 1L;
	public static final String OWNER_LAST_NAME = "Smith";

	private OwnerService ownerService;

	@BeforeEach
	void setUp() {
		ownerService = new OwnerMapService(new PetMapService(new PetTypeMapService()));

		ownerService.save(Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build());
	}

	@Test
	void findByExistingLastName() {
		Owner owner = ownerService.findByLastName(OWNER_LAST_NAME);

		assertNotNull(owner);
		assertEquals(OWNER_ID, owner.getId());
		assertEquals(OWNER_LAST_NAME, owner.getLastName());
	}

	@Test
	void findByNonExistingLastName() {
		Owner owner = ownerService.findByLastName("OWNER_LAST_NAME");

		assertNull(owner);
	}

	@Test
	void findById() {
		Owner owner = ownerService.findById(OWNER_ID);

		assertEquals(OWNER_ID, owner.getId());

	}

	@Test
	void findAll() {
		Set<Owner> owners = ownerService.findAll();

		assertEquals(1, owners.size());
	}

	@Test
	void deleteById() {
		ownerService.deleteById(OWNER_ID);

		assertNull(ownerService.findById(OWNER_ID));

	}

	@Test
	void delete() {
		ownerService.delete(ownerService.findById(OWNER_ID));

		assertNull(ownerService.findById(OWNER_ID));
	}

	@Test
	void saveWithId() {
		Long id = 2L;

		Owner owner = ownerService.save(Owner.builder().id(id).build());

		assertEquals(id, owner.getId());
	}

	@Test
	void saveWithoutId() {

		Owner owner = ownerService.save(new Owner());

		assertNotNull(owner);
		assertNotNull(owner.getId());
	}

	@Test
	void saveAll() {
		Set<Owner> owners = new HashSet<>();

		owners.add(Owner.builder().id(2L).build());
		owners.add(Owner.builder().id(3L).build());

		Set<Owner> ownersSaved = (Set) ownerService.saveAll(owners);

		assertEquals(2, ownersSaved.size());
		assertEquals(3, ownerService.findAll().size());

	}
}