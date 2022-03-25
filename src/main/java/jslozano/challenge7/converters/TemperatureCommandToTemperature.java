package jslozano.challenge7.converters;

import jslozano.challenge7.commands.TemperatureCommand;
import jslozano.challenge7.model.Temperature;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TemperatureCommandToTemperature implements Converter<TemperatureCommand, Temperature> {
    @Synchronized
    @Nullable
    @Override
    public Temperature convert(TemperatureCommand source) {
        if (source == null){
            return null;
        }
        Temperature temperature = new Temperature();

        temperature.setId(source.getId());
        temperature.setTemperature1(source.getTemperature1());
        temperature.setTemperature2(source.getTemperature2());
        temperature.setTemperature3(source.getTemperature3());
        temperature.setTemperature4(source.getTemperature4());

        return temperature;
    }
}
