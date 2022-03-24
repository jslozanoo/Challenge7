package jslozano.challenge7.repositories;

import jslozano.challenge7.model.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
}
