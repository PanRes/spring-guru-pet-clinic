package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping({"","/","index","index.html"})
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

	@RequestMapping({"find","/find"})
	public String findOwners(Model model) {

		return null;
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");

		modelAndView.addObject(ownerService.findById(ownerId));

		return modelAndView;
	}

}
