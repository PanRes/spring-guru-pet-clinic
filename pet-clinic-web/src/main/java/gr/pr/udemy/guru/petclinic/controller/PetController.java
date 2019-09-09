package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners/{ownerId}/pets")
public class PetController {

	private final OwnerService ownerService;
	private final PetService petService;
	private final PetTypeService petTypeService;

	@ModelAttribute("petType")
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

	@GetMapping("new")
	public String createPet(Owner owner, Model model) {
		Pet pet = new Pet();
		pet.setOwner(owner);
		model.addAttribute("pet", pet);

		return "pets/createOrUpdatePetForm";
	}

	@PostMapping("new")
	public String saveNewPet(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
		if (StringUtils.hasLength(pet.getName()) && owner.hasAlreadyPet(pet)) {
			result.rejectValue("name", "duplicate", "already exists");
			result.rejectValue("birthDate", "duplicate", "already exists");
			result.rejectValue("petType", "duplicate", "already exists");
		}

		if (result.hasErrors()) {
			model.addAttribute("pet", pet);
			return "pets/createOrUpdatePetForm";
		}
		else {
			owner.addPet(pet);
			pet.setOwner(owner);
			ownerService.save(owner);
			return "redirect:/owners/" + owner.getId();
		}
	}

	@GetMapping("{petId}/edit")
	public String updatePet(@PathVariable Long petId, Model model) {
		model.addAttribute("pet", petService.findById(petId));

		return "pets/createOrUpdatePetForm";
	}

	@PostMapping("{petId}/edit")
	public String saveUpdatedPet(@Valid Pet pet, BindingResult result, Owner owner, Model model, @PathVariable Long petId) {
		if (result.hasErrors()) {
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return "pets/createOrUpdatePetForm";
		}
		else {
			pet.setId(petId);
			owner.addPet(pet);
			petService.save(pet);
			return "redirect:/owners/" + owner.getId();
		}
	}

}
