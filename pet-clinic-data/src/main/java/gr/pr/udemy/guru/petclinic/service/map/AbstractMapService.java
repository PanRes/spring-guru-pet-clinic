package gr.pr.udemy.guru.petclinic.service.map;

import gr.pr.udemy.guru.petclinic.entity.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T object) {

		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}

			map.put(object.getId(), object);
		}
		else {
			throw new RuntimeException(object.getClass() + " is null");
		}

		return object;
	}

	void deleteById(ID id) {
		map.remove(id);
	}

	void delete(T object) {
		map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
	}

	Iterable<T> saveAll(Iterable<T> objects) {
		objects.forEach(this::save);
		return objects;
	}

	private long getNextId() {
		Long nextInt = null;

		try {
			nextInt = Collections.max(map.keySet()) + 1;
		}
		catch (NoSuchElementException e) {
			nextInt = 1L;
		}

		return nextInt;
	}

}
