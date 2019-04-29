package gr.pr.udemy.guru.petclinic.bootstarp;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.VetService;
import gr.pr.udemy.guru.petclinic.service.map.OwnerServiceMap;
import gr.pr.udemy.guru.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataInitializer() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
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
