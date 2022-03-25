package jslozano.challenge7.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TemperatureCommand {
    private Long id;

    private Double temperature1;
    private Double temperature2;
    private Double temperature3;
    private Double temperature4;
}
