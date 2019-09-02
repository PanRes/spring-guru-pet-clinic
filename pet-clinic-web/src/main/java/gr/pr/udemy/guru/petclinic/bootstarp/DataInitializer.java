package gr.pr.udemy.guru.petclinic.bootstarp;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType("dog");
		petTypeService.save(dog);

		PetType cat = new PetType("cat");
		petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Panagiotis");
		owner1.setLastName("Ressos");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Makis");
		owner2.setLastName("Kotsovos");

		ownerService.save(owner2);

		System.out.println("Owners Initialized");

		Vet vet1 = new Vet();
		vet1.setFirstName("Filippos");
		vet1.setLastName("Georgantas");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Angel");
		vet2.setLastName("Pearl");

		vetService.save(vet2);

		System.out.println("Vets Initialized");

	}
}
