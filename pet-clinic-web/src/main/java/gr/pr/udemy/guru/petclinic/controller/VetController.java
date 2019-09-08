package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class VetController {

	private final VetService vetService;

	@RequestMapping({"vets","/vets","/vets.html","vets/index","vets/index.html","/vets/index","/vets/index.html"})
	public String listVets(Model model) {

		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
