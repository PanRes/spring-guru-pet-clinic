package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService ownerService;

	@InjectMocks
	private OwnerController ownerController;

	private MockMvc mockMvc;

	private static Set<Owner> owners;
	private static Owner owner1;

	@BeforeEach
	void setUp() {
		owners = new HashSet<>();

		owner1 = Owner.builder().id(1L).lastName("Smithopoulos").build();
		owners.add(owner1);
		owners.add(Owner.builder().id(2L).lastName("Anasmithovitch").build());
		owners.add(Owner.builder().id(2L).lastName("Smith").build());

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

/*
	@Test
	void listOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(owners.size())));
	}
*/

	@Test
	void findOwners() throws Exception {

		mockMvc.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/findOwners"))
				.andExpect(model().attributeExists("owner"));

		verifyZeroInteractions(ownerService);
	}

	@Test
	void showOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner1);

		mockMvc.perform(get("/owners/" + 1L))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/ownerDetails"))
				.andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

	@Test
	void findManyByLastNameLikeMultiple() throws Exception {
		when(ownerService.findByLastNameLike(anyString())).thenReturn(new ArrayList<>(owners));

		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/ownersList"))
				.andExpect(model().attribute("selections", hasSize(owners.size())));

	}

	@Test
	void findManyByLastNameLikeOne() throws Exception {
		when(ownerService.findByLastNameLike(anyString())).thenReturn(Collections.singletonList(owner1));

		mockMvc.perform(get("/owners"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/" + owner1.getId()));

	}

	@Test
	void findManyByLastNameLikeNone() throws Exception {
		when(ownerService.findByLastNameLike(anyString())).thenReturn(new ArrayList<>());

		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/findOwners"))
				.andExpect(model().attributeDoesNotExist("owners"))
				.andExpect(model().attribute("owner", hasProperty("lastName", is(""))));

	}

}