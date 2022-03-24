package jslozano.challenge7.bootstrap;

import jslozano.challenge7.model.Location;
import jslozano.challenge7.model.Temperature;
import jslozano.challenge7.model.WeatherRegister;
import jslozano.challenge7.repositories.LocationRepository;
import jslozano.challenge7.repositories.WeatherRegisterRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

        WeatherRegister weatherRegister1 = new WeatherRegister();
        weatherRegister1.setDate(LocalDate.of(2022, 03, 22));

        WeatherRegister weatherRegister2 = new WeatherRegister();
        weatherRegister2.setDate(LocalDate.of(2022, 03, 23));

        WeatherRegister weatherRegister3 = new WeatherRegister();
        weatherRegister3.setDate(LocalDate.of(2022, 03, 21));

        WeatherRegister weatherRegister4 = new WeatherRegister();
        weatherRegister4.setDate(LocalDate.of(2022, 03, 24));

        Temperature temperature1 = new Temperature();
        temperature1.setTemperature1(89.7);
        temperature1.setTemperature2(84.3);
        temperature1.setTemperature3(91.2);
        temperature1.setTemperature4(93.1);


        Temperature temperature2 = new Temperature();
        temperature2.setTemperature1(86.5);
        temperature2.setTemperature2(81.3);
        temperature2.setTemperature3(90.2);
        temperature2.setTemperature4(88.1);

        Temperature temperature3 = new Temperature();
        temperature3.setTemperature1(85.3);
        temperature3.setTemperature2(99.3);
        temperature3.setTemperature3(98.4);
        temperature3.setTemperature4(96.3);

        Temperature temperature4 = new Temperature();
        temperature4.setTemperature1(93.5);
        temperature4.setTemperature2(96.43);
        temperature4.setTemperature3(88.32);
        temperature4.setTemperature4(88.43);


        weatherRegister1.setTemperature(temperature1);
        temperature1.setRegister(weatherRegister1);

        weatherRegister2.setTemperature(temperature2);
        temperature2.setRegister(weatherRegister2);

        weatherRegister3.setTemperature(temperature3);
        temperature3.setRegister(weatherRegister3);

        weatherRegister4.setTemperature(temperature4);
        temperature4.setRegister(weatherRegister4);

        Location location1 = new Location();
        location1.setLat(39.12);
        location1.setLon(-94.74);
        location1.setCity("kansas city");
        location1.setState("kansas");

        location1.getRegisters().add(weatherRegister1);
        location1.getRegisters().add(weatherRegister2);

        weatherRegister1.setLocation(location1);
        weatherRegister2.setLocation(location1);

        Location location2 = new Location();
        location2.setLat(40.71);
        location2.setLon(74.00);
        location2.setCity("new york");
        location2.setState("new york");

        location2.getRegisters().add(weatherRegister3);

        weatherRegister3.setLocation(location2);


        Location location3 = new Location();
        location3.setLat(37.54);
        location3.setLon(77.43);
        location3.setCity("richmond");
        location3.setState("virginia");

        location3.getRegisters().add(weatherRegister4);
        weatherRegister4.setLocation(location3);

        locations.add(location1);
        locations.add(location2);
        locations.add(location3);

        return locations;
    }
}
