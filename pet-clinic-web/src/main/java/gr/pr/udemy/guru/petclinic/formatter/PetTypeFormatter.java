package gr.pr.udemy.guru.petclinic.formatter;

import gr.pr.udemy.guru.petclinic.entity.PetType;
import gr.pr.udemy.guru.petclinic.service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	@Override
	public PetType parse(String s, Locale locale) throws ParseException {
		for (PetType petType : petTypeService.findAll()) {
			if (s.equals(petType.getName())) {
				return petType;
			}
		}

		throw new ParseException("PetType not found: " + s, 0);
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}
}
