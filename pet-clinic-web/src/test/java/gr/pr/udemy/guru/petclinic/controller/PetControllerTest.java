package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

	@Mock
	private OwnerService ownerService;

	@Mock
	private PetService petService;

	@Mock
	private PetTypeService petTypeService;

	@InjectMocks
	private PetController petController;

	private MockMvc mockMvc;

	private static Set<PetType> petTypes;
	private static Owner owner;
	private static Pet pet;

	@BeforeEach
	void setUp() {
		petTypes = new HashSet<>();
		petTypes.add(PetType.builder().id(1L).name("Dog").build());
		petTypes.add(PetType.builder().id(2L).name("Cat").build());

		owner = Owner.builder().id(1L).lastName("Smithopoulos").build();
		pet = Pet.builder().id(1L).owner(owner).build();
		owner.addPet(pet);

		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

	}

	@Test
	void initCreationPetForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(get("/owners/" + owner.getId() + "/pets/new"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("owner"))
				.andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void processCreationPetForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/" + owner.getId() + "/pets/new"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/" + owner.getId()));

		verify(petService).save(any());
	}

	@Test
	void initUpdatePetForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		when(petService.findById(anyLong())).thenReturn(pet);

		mockMvc.perform(get("/owners/" + owner.getId() + "/pets/" + pet.getId() + "/edit"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("owner"))
				.andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void processUpdatePetForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/" + owner.getId() + "/pets/" + pet.getId() + "/edit"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/" + owner.getId()));

		verify(petService).save(any());
	}
}