package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners/{ownerId}/pets")
public class PetController {

	private final OwnerService ownerService;
	private final PetService petService;
	private final PetTypeService petTypeService;

	@ModelAttribute("types")
	public Set<PetType> populateTypes() {
		return petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable Long ownerId) {
		return ownerService.findById(ownerId);
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


}
