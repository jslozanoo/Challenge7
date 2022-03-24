package jslozano.challenge7.repositories;

import jslozano.challenge7.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
