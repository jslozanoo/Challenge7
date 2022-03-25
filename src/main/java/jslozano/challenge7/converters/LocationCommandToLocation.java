package jslozano.challenge7.converters;

import jslozano.challenge7.commands.LocationCommand;
import jslozano.challenge7.model.Location;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LocationCommandToLocation implements Converter<LocationCommand, Location> {
    /*
    private final WeatherRegisterCommandToWeatherRegister registerConverter;

    public LocationCommandToLocation(WeatherRegisterCommandToWeatherRegister registerConverter) {
        this.registerConverter = registerConverter;
    }

     */

    @Override
    @Synchronized
    @Nullable
    public Location convert(LocationCommand source) {
        if(source == null) {
            return null;
        }
        Location location = new Location();

        location.setId(source.getId());

        location.setLat(source.getLat());
        location.setLon(source.getLon());
        location.setCity(source.getCity());
        location.setState(source.getState());
        /*
        if(source.getRegisters() != null && source.getRegisters().size() > 0){
            source.getRegisters().forEach(register ->
                    location.getRegisters().add(registerConverter.convert(register)));
        }

         */

        return location;
    }
}
