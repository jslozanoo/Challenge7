package jslozano.challenge7.converters;

import jslozano.challenge7.commands.WeatherRegisterCommand;
import jslozano.challenge7.model.WeatherRegister;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class WeatherRegisterToWeatherRegisterCommand implements Converter<WeatherRegister,
        WeatherRegisterCommand> {
    private final TemperatureToTemperatureCommand temperatureConverter;
    private final LocationToLocationCommand locationConverter;

    public WeatherRegisterToWeatherRegisterCommand(TemperatureToTemperatureCommand temperatureConverter,
                                                   LocationToLocationCommand locationConverter) {
        this.temperatureConverter = temperatureConverter;
        this.locationConverter = locationConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public WeatherRegisterCommand convert(WeatherRegister source) {
        if(source == null){
            return null;
        }
        final WeatherRegisterCommand registerCommand = new WeatherRegisterCommand();
        registerCommand.setId(source.getId());
        registerCommand.setDate(source.getDate());
        registerCommand.setTemperature(this.temperatureConverter.
                convert(source.getTemperature()));
        registerCommand.setLocation(this.locationConverter.convert(source.getLocation()));

        return registerCommand;
    }

}

