package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("owners")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;

	/**
	 * Do not allow mvc to edit id field
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

}
