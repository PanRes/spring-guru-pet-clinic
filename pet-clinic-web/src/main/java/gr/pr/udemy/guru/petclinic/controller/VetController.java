package gr.pr.udemy.guru.petclinic.controller;

import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

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

	@RequestMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetJson(){
		return vetService.findAll();
	}
}
