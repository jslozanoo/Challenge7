package jslozano.challenge7.repositories;

import jslozano.challenge7.model.WeatherRegister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRegisterRepository extends CrudRepository<WeatherRegister, Long> {

}
