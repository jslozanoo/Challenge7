package jslozano.challenge7.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LocationCommand {
    private Long id;

    private Double lat;
    private Double lon;
    private String city;
    private String state;
    /*
    private Set<WeatherRegisterCommand> registers;

     */
}
