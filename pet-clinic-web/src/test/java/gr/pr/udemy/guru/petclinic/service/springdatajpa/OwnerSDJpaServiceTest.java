package gr.pr.udemy.guru.petclinic.service.springdatajpa;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.repository.OwnerRepository;
import gr.pr.udemy.guru.petclinic.repository.PetRepository;
import gr.pr.udemy.guru.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	private static final String LAST_NAME = "Smith";
	private static final long ID = 1L;
	private static Owner owner;

	@Mock
	private OwnerRepository ownerRepository;

	@Mock
	private PetRepository petRepository;

	@Mock
	private PetTypeRepository petTypeRepository;

	@InjectMocks
	private OwnerSDJpaService ownerService;

	@BeforeEach
	void setUp() {
		owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
	}

	@Test
	void findByLastName() {
		when(ownerRepository.findFirstByLastName(any())).thenReturn(owner);

		Owner returnedOwner = ownerService.findByLastName(LAST_NAME);

		assertEquals(LAST_NAME, returnedOwner.getLastName());
		verify(ownerRepository).findFirstByLastName(any());
	}

	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

		Owner returnedOwner = ownerService.findById(ID);

		assertNotNull(returnedOwner);
		verify(ownerRepository).findById(anyLong());
	}

	@Test
	void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

		Owner returnedOwner = ownerService.findById(ID);

		assertNull(returnedOwner);
		verify(ownerRepository).findById(anyLong());
	}

	@Test
	void findAll() {
		Set<Owner> owners = new HashSet<>();
		owners.add(Owner.builder().id(ID).build());
		owners.add(Owner.builder().id(2L).build());
		when(ownerRepository.findAll()).thenReturn(owners);

		Set<Owner> returnedOwners = ownerService.findAll();

		assertNotNull(returnedOwners);
		assertEquals(2, returnedOwners.size());
		verify(ownerRepository).findAll();
	}

	@Test
	void deleteById() {
		ownerService.deleteById(ID);

		verify(ownerRepository).deleteById(anyLong());

	}

	@Test
	void delete() {
		ownerService.delete(owner);

		verify(ownerRepository).delete(any());
	}

	@Test
	void save() {
		when(ownerRepository.save(any())).thenReturn(owner);

		Owner returnedOwner = ownerService.save(Owner.builder().id(ID).build());

		assertNotNull(returnedOwner);
		assertEquals(LAST_NAME, returnedOwner.getLastName());
		verify(ownerRepository).save(any());
	}

	@Test
	void saveTwice() {
		Owner owner2 = Owner.builder().id(2L).build();

		when(ownerRepository.save(any())).thenReturn(owner).thenReturn(owner2);

		Owner returnedOwner1 = ownerService.save(owner);
		Owner returnedOwner2 = ownerService.save(owner2);

		assertNotNull(returnedOwner1);
		assertNotNull(returnedOwner2);
		assertEquals(LAST_NAME, returnedOwner1.getLastName());
		verify(ownerRepository, times(2)).save(any());
	}

	@Test
	void saveAll() {
		Set<Owner> owners = new HashSet<>();
		owners.add(Owner.builder().id(ID).build());
		owners.add(Owner.builder().id(2L).build());
		when(ownerRepository.saveAll(any())).thenReturn(owners);

		Set<Owner> returnedOwners = ownerService.saveAll(owners);

		assertNotNull(returnedOwners);
		assertEquals(2, returnedOwners.size());
	}
}