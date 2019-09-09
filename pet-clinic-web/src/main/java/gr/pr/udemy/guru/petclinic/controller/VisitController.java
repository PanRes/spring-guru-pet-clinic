package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.entity.Visit;
import gr.pr.udemy.guru.petclinic.service.PetService;
import gr.pr.udemy.guru.petclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits")
public class VisitController {

	private final VisitService visitService;
	private final PetService petService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("pet")
	public Pet loadPetWithVisit(@PathVariable Long petId) {
		return petService.findById(petId);
	}

	@GetMapping("new")
	public String createNewPetVisit(Model model, Pet pet) {
		model.addAttribute("visit", Visit.builder().pet(pet).build());
		return "pets/createOrUpdateVisitForm";
	}

	@PostMapping("new")
	public String processNewPetVisit(@Valid Visit visit, BindingResult result, @PathVariable Long ownerId, Pet pet) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}
		else {
			pet.addVisit(visit);
			visitService.save(visit);
			return "redirect:/owners/" + ownerId;
		}
	}

	@GetMapping("{visitId}/edit")
	public String updatePetVisit(@PathVariable Long visitId, Model model) {
		model.addAttribute("visit", visitService.findById(visitId));
		return "pets/createOrUpdateVisitForm";
	}

	/*	Fixme: ownerDetails does not get Update changes*/
	@PostMapping("{visitId}/edit")
	public String processUpdatePetVisit(@Valid Visit visit, Pet pet, BindingResult result,
										@PathVariable Long ownerId, @PathVariable Long visitId) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}
		else {
			visit.setId(visitId);
			visit.setPet(pet);
			visitService.save(visit);
			return "redirect:/owners/" + ownerId;
		}
	}


}
