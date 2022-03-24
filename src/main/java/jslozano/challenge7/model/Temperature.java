package jslozano.challenge7.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double[] temperatures;

    @OneToOne
    private WeatherRegister register;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double[] getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Double[] temperatures) {
        this.temperatures = temperatures;
    }

    public WeatherRegister getRegister() {
        return register;
    }

    public void setRegister(WeatherRegister register) {
        this.register = register;
    }
}
