package gr.pr.udemy.guru.petclinic.bootstarp;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	@Autowired
	public DataInitializer(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		ownerService.save(new Owner(1L,"Panagiotis","Ressos"));
		ownerService.save(new Owner(2L,"Makis","Kotsovos"));

		System.out.println("Owners Initialized");

		vetService.save(new Vet(1L,"Filippos","Georgantas"));
		vetService.save(new Vet(2L,"Angel","Perlianis"));

		System.out.println("Vets Initialized");

	}
}
