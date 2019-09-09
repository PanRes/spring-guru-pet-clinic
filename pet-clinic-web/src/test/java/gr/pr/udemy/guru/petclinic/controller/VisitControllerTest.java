package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.entity.Visit;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

	@Mock
	private PetService petService;

	@Mock
	private VisitService visitService;

	@InjectMocks
	private VisitController visitController;

	private MockMvc mockMvc;
	private Pet pet;
	private Visit visit;

	@BeforeEach
	void setUp() {
		pet = Pet.builder().id(1L).build();
		visit = Visit.builder().id(1L).build();

		mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
	}

	@Test
	void createNewPetVisit() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);

		mockMvc.perform(get("/owners/1/pets/" + pet.getId()+ "/visits/new"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("visit"))
				.andExpect(view().name("pets/createOrUpdateVisitForm"));
	}

	@Test
	void processNewPetVisit() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		when(visitService.save(any())).thenReturn(visit);

		mockMvc.perform(post("/owners/1/pets/" + pet.getId()+ "/visits/new"))
				.andExpect(status().is3xxRedirection())
				.andExpect(model().attributeExists("visit"))
				.andExpect(view().name("redirect:/owners/1"));
	}

	@Test
	void updatePetVisit() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);

		mockMvc.perform(get("/owners/1/pets/" + pet.getId()+ "/visits/" + visit.getId() + "/edit"))
				.andExpect(status().isOk())
				.andExpect(view().name("pets/createOrUpdateVisitForm"));

		verify(visitService).findById(anyLong());
	}

//	TODO: refactor when controller method is fixed
	@Test
	void processUpdatePetVisit() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);

		mockMvc.perform(post("/owners/1/pets/" + pet.getId()+ "/visits/" + visit.getPet() + "/edit"))
				.andExpect(status().is3xxRedirection())
				.andExpect(model().attributeExists("visit"))
				.andExpect(view().name("redirect:/owners/1"));

		verify(visitService).findById(anyLong());
	}
}