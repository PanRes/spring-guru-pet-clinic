package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.Specialty;
import gr.pr.udemy.guru.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
	
	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Specialty specialty) {
		super.delete(specialty);
	}

	@Override
	public Specialty save(Specialty specialty) {
		return super.save(specialty);
	}

	@Override
	public Iterable<Specialty> saveAll(Iterable<Specialty> specialties) {
		return super.saveAll(specialties);
	}
}
