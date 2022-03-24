package jslozano.challenge7.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature1;
    private Double temperature2;
    private Double temperature3;
    private Double temperature4;


    @OneToOne
    private WeatherRegister register;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(Double temperature1) {
        this.temperature1 = temperature1;
    }

    public Double getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(Double temperature2) {
        this.temperature2 = temperature2;
    }

    public Double getTemperature3() {
        return temperature3;
    }

    public void setTemperature3(Double temperature3) {
        this.temperature3 = temperature3;
    }

    public Double getTemperature4() {
        return temperature4;
    }

    public void setTemperature4(Double temperature4) {
        this.temperature4 = temperature4;
    }

    public WeatherRegister getRegister() {
        return register;
    }

    public void setRegister(WeatherRegister register) {
        this.register = register;
    }

}
