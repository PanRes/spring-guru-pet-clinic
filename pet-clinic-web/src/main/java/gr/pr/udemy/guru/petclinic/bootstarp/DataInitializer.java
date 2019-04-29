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
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Panagiotis");
		owner1.setLastName("Ressos");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Makis");
		owner2.setLastName("Kotsovos");

		ownerService.save(owner2);

		System.out.println("Owners Initialized");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Filippos");
		vet1.setLastName("Georgantas");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Angel");
		vet2.setLastName("Pearl");

		vetService.save(vet2);

		System.out.println("Vets Initialized");

	}
}