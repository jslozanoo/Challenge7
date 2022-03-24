package jslozano.challenge7.bootstrap;

import jslozano.challenge7.model.Location;
import jslozano.challenge7.model.Temperature;
import jslozano.challenge7.model.WeatherRegister;
import jslozano.challenge7.repositories.LocationRepository;
import jslozano.challenge7.repositories.WeatherRegisterRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RegistersBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final WeatherRegisterRepository weatherRegisterRepository;
    private final LocationRepository locationRepository;


    public RegistersBootstrap(WeatherRegisterRepository weatherRegisterRepository,
                              LocationRepository locationRepository) {
        this.weatherRegisterRepository = weatherRegisterRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        locationRepository.saveAll(getRegisters());
    }

    private List<Location> getRegisters(){
        List<Location> locations = new ArrayList<>();
        WeatherRegister weatherRegister = new WeatherRegister();
        weatherRegister.setDate(new Date(2022, 03, 22));

        Temperature temperature = new Temperature();
        Double[] temperatures = {89.7, 84.3, 91.2, 93.1};
        temperature.setTemperatures(temperatures);

        weatherRegister.setTemperature(temperature);
        temperature.setRegister(weatherRegister);

        Location location = new Location();
        location.setLat(39.12);
        location.setLon(-94.74);
        location.setCity("kansas city");
        location.setState("kansas");

        location.getRegisters().add(weatherRegister);
        weatherRegister.setLocation(location);




        locations.add(location);

        return locations;
    }
}
