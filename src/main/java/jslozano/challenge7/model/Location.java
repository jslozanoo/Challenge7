package jslozano.challenge7.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lat;
    private Double lon;
    private String city;
    private String state;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location", orphanRemoval = true)
    private Set<WeatherRegister> registers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<WeatherRegister> getRegisters() {
        return registers;
    }

    public void setRegisters(Set<WeatherRegister> registers) {
        this.registers = registers;
    }
}
