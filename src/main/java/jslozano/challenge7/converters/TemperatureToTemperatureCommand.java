package jslozano.challenge7.converters;

import jslozano.challenge7.commands.TemperatureCommand;
import jslozano.challenge7.model.Temperature;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TemperatureToTemperatureCommand implements Converter<Temperature, TemperatureCommand> {

    @Synchronized
    @Nullable
    @Override
    public TemperatureCommand convert(Temperature source) {
        if (source == null){
            return null;
        }
        TemperatureCommand temperatureCommand = new TemperatureCommand();

        temperatureCommand.setId(source.getId());
        temperatureCommand.setTemperature1(source.getTemperature1());
        temperatureCommand.setTemperature2(source.getTemperature2());
        temperatureCommand.setTemperature3(source.getTemperature3());
        temperatureCommand.setTemperature4(source.getTemperature4());

        return temperatureCommand;
    }

}
