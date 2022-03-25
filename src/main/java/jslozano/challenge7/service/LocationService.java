package jslozano.challenge7.service;

import jslozano.challenge7.commands.WeatherRegisterCommand;

public interface LocationService {

    WeatherRegisterCommand findCommandById(Long id);
    WeatherRegisterCommand saveRegisterCommand(WeatherRegisterCommand registerCommand);

}
