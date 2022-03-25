package jslozano.challenge7.service;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.converters.LocationCommandToLocation;
import jslozano.challenge7.converters.LocationToLocationCommand;
import jslozano.challenge7.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


public class LocationServiceImpl {
    /*
    private final LocationRepository locationRepository;
    private final LocationCommandToLocation locationCommandToLocation;
    private final LocationToLocationCommand locationToLocationCommand;

    public LocationServiceImpl(LocationRepository locationRepository,
                               LocationCommandToLocation locationCommandToLocation,
                               LocationToLocationCommand locationToLocationCommand) {
        this.locationRepository = locationRepository;
        this.locationCommandToLocation = locationCommandToLocation;
        this.locationToLocationCommand = locationToLocationCommand;
    }


    @Transactional
    @Override
    public WeatherRegisterCommand findCommandById(Long id) {
        return null;
    }

    @Override
    public WeatherRegisterCommand saveRegisterCommand(WeatherRegisterCommand registerCommand) {
        return null;
    }

     */
}
