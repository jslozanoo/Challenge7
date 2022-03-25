package jslozano.challenge7.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class WeatherRegisterCommand {
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate date;
    private TemperatureCommand temperature;
    private LocationCommand location;
}
