package jslozano.challenge7.converters;

import jslozano.challenge7.commands.LocationCommand;
import jslozano.challenge7.model.Location;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationCommand implements Converter<Location, LocationCommand> {
    /*
    private final WeatherRegisterToWeatherRegisterCommand registerConverter;

    public LocationToLocationCommand(WeatherRegisterToWeatherRegisterCommand registerConverter) {
        this.registerConverter = registerConverter;
    }

     */

    @Synchronized
    @Nullable
    @Override
    public LocationCommand convert(Location source) {
        if(source == null) {
            return null;
        }
        LocationCommand locationCommand = new LocationCommand();

        locationCommand.setId(source.getId());
        locationCommand.setLat(source.getLat());
        locationCommand.setLon(source.getLon());
        locationCommand.setCity(source.getCity());
        locationCommand.setState(source.getState());
        /*

        if(source.getRegisters() != null && source.getRegisters().size() > 0){
            source.getRegisters().forEach(register ->
                    locationCommand.getRegisters().add(registerConverter.convert(register)));
        }

         */

        return locationCommand;

    }
}
