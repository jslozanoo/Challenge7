package jslozano.challenge7.service;

import jslozano.challenge7.model.WeatherRegister;

import java.util.Set;

public interface WeatherRegisterService {
    Set<WeatherRegister> getRegisters();
    // WeatherRegister findById(Long id);
}
