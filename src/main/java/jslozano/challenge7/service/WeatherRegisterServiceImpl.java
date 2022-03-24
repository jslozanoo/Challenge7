package jslozano.challenge7.service;

import jslozano.challenge7.model.WeatherRegister;
import jslozano.challenge7.repositories.WeatherRegisterRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WeatherRegisterServiceImpl implements WeatherRegisterService {
    private final WeatherRegisterRepository weatherRepository;

    public WeatherRegisterServiceImpl(WeatherRegisterRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Set<WeatherRegister> getRegisters() {
        Set<WeatherRegister> registers = new HashSet<>();
        weatherRepository.findAll().iterator().
                forEachRemaining(register->registers.add(register));
        return registers;
    }

    @Override
    public WeatherRegister findById(Long id) {
        Optional<WeatherRegister> registerOptional = weatherRepository.findById(id);
        if(registerOptional.isEmpty()){
            throw new RuntimeException("Register Not Found");
        }
        return registerOptional.get();
    }
}
