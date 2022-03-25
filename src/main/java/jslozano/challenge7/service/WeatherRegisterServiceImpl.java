package jslozano.challenge7.service;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.converters.LocationCommandToLocation;
import jslozano.challenge7.converters.LocationToLocationCommand;
import jslozano.challenge7.converters.WeatherRegisterCommandToWeatherRegister;
import jslozano.challenge7.converters.WeatherRegisterToWeatherRegisterCommand;
import jslozano.challenge7.model.Location;
import jslozano.challenge7.model.WeatherRegister;
import jslozano.challenge7.repositories.LocationRepository;
import jslozano.challenge7.repositories.WeatherRegisterRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WeatherRegisterServiceImpl implements WeatherRegisterService {
    private final WeatherRegisterRepository weatherRepository;
    private final LocationRepository locationRepository;
    private final WeatherRegisterToWeatherRegisterCommand weatherRegisterToWeatherRegisterCommand;
    private final WeatherRegisterCommandToWeatherRegister weatherRegisterCommandToWeatherRegister;
    private final LocationCommandToLocation locationCommandToLocation;
    private final LocationToLocationCommand locationToLocationCommand;

    public WeatherRegisterServiceImpl(WeatherRegisterRepository weatherRepository,
                                      LocationRepository locationRepository,
                                      LocationCommandToLocation locationCommandToLocation,
                                      LocationToLocationCommand locationToLocationCommand,
                                      WeatherRegisterToWeatherRegisterCommand weatherRegisterToWeatherRegisterCommand,
                                      WeatherRegisterCommandToWeatherRegister weatherRegisterCommandToWeatherRegister,
                                      LocationCommandToLocation locationCommandToLocation1,
                                      LocationToLocationCommand locationToLocationCommand1) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
        this.weatherRegisterToWeatherRegisterCommand = weatherRegisterToWeatherRegisterCommand;
        this.weatherRegisterCommandToWeatherRegister = weatherRegisterCommandToWeatherRegister;
        this.locationCommandToLocation = locationCommandToLocation1;
        this.locationToLocationCommand = locationToLocationCommand1;
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

    @Override
    public WeatherRegisterCommand findCommandById(Long id) {
        return this.weatherRegisterToWeatherRegisterCommand.convert(findById(id));
        // Goes to the database and find the weather register by its id
    }

    @Override
    public WeatherRegisterCommand saveRegisterCommand(WeatherRegisterCommand registerCommand) {
        WeatherRegister registerDetached = weatherRegisterCommandToWeatherRegister.
                convert(registerCommand); // register detached it's a POJO
        Location locationSaved = locationRepository.save(registerDetached.getLocation());
        WeatherRegister savedRegister = weatherRepository.save(registerDetached);
        // savedRegister has the id property
        return weatherRegisterToWeatherRegisterCommand.convert(savedRegister);
    }

    @Override
    public void deleteById(Long id) {
        weatherRepository.deleteById(id);
    }
}
