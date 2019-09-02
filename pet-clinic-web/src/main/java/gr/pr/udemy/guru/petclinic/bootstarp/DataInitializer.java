package gr.pr.udemy.guru.petclinic.bootstarp;

import gr.pr.udemy.guru.petclinic.entity.Owner;
import gr.pr.udemy.guru.petclinic.entity.Pet;
import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.entity.Vet;
import gr.pr.udemy.guru.petclinic.service.OwnerService;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import gr.pr.udemy.guru.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@CommonsLog
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

		Owner owner1 = new Owner("Panagiotis", "Ressos", "Patriarxou Grigoriou 15", "Kalithea",
				"1234567890");
		owner1.addPet(new Pet("Rex", dog, owner1, LocalDate.of(2016, 06,05)));
		owner1.addPet(new Pet("Krypto", dog, owner1, LocalDate.of(2014, 06,12)));

		ownerService.save(owner1);

		Owner owner2 = new Owner("Makis", "Kotsovos", "Agiou Ierotheou 125", "Peristeri",
				"0987654321");
		owner2.addPet(new Pet("Mjolnir", cat, LocalDate.of(2017,05,05)));

		ownerService.save(owner2);

		log.info("Owners Initialized");

		Vet vet1 = new Vet();
		vet1.setFirstName("Filippos");
		vet1.setLastName("Georgantas");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Angel");
		vet2.setLastName("Pearl");

		vetService.save(vet2);

		log.info("Vets Initialized");

	}
}
