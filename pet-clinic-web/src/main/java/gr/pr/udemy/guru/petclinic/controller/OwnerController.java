package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("owners")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;

	/**
	 * Do not allow model to get id field
	 */
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

//	@RequestMapping({"","/","index","index.html"})
	@Deprecated
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

	@RequestMapping({"find","/find"})
	public String findOwners(Model model) {
		model.addAttribute("owner", new Owner());

		return "owners/findOwners";
	}

	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getLastName() == null) {
			owner.setLastName("");
		}

		List<Owner> results = ownerService.findByLastNameLike(owner.getLastName());

		if (results.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		}
		else if (results.size() == 1) {
			owner = results.get(0);
			return "redirect:/owners/" + owner.getId();
		}
		else {
			model.addAttribute("selections", results);
			return "owners/ownersList";
		}
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");

		modelAndView.addObject(ownerService.findById(ownerId));

		return modelAndView;
	}

	@GetMapping("new")
	public String createOwner(Model model) {
		model.addAttribute("owner", new Owner());

		return "owners/createOrUpdateOwnerForm";
	}

	@PostMapping("new")
	public String saveNewOwner(@Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}
		else {
			owner = ownerService.save(owner);
			return "redirect:/owners/" + owner.getId();
		}
	}

	@GetMapping("{ownerId}/edit")
	public String updateOwner(@PathVariable Long ownerId, Model model) {
		model.addAttribute("owner", ownerService.findById(ownerId));

		return "owners/createOrUpdateOwnerForm";
	}

	@PostMapping("{ownerId}/edit")
	public String saveUpdatedOwner(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
		if (result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		}
		else {
			owner.setId(ownerId);
			owner = ownerService.save(owner);
			return "redirect:/owners/" + owner.getId();
		}
	}

}
