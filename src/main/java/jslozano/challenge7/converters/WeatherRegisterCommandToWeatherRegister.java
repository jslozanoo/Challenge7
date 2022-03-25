package jslozano.challenge7.converters;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.model.WeatherRegister;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class WeatherRegisterCommandToWeatherRegister implements
        Converter<WeatherRegisterCommand, WeatherRegister> {
    private final TemperatureCommandToTemperature temperatureConverter;
    private final LocationCommandToLocation locationConverter;

    public WeatherRegisterCommandToWeatherRegister(TemperatureCommandToTemperature
                                                           temperatureConverter, LocationCommandToLocation locationConverter) {
        this.temperatureConverter = temperatureConverter;
        this.locationConverter = locationConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public WeatherRegister convert(WeatherRegisterCommand source) {
        if(source == null){
            return null;
        }
        final WeatherRegister register = new WeatherRegister();
        register.setId(source.getId());
        register.setDate(source.getDate());
        register.setTemperature(this.temperatureConverter.convert(source.getTemperature()));
        register.setLocation(locationConverter.convert(source.getLocation()));

        return register;

    }
}
