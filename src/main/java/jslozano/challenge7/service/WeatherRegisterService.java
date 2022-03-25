package jslozano.challenge7.service;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.model.WeatherRegister;

import java.util.Set;

public interface WeatherRegisterService {
    Set<WeatherRegister> getRegisters();
    WeatherRegister findById(Long id);
    WeatherRegisterCommand findCommandById(Long id);
    WeatherRegisterCommand saveRegisterCommand(WeatherRegisterCommand registerCommand);
    void deleteById(Long id);
}
