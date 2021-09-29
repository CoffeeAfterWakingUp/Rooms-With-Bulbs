package com.example.roomsWithBulbs.entity;

public class Room {
    private Long id;
    private String name;
    private Boolean bulb;
    private Country country;
    private String user;

    public Room(Long id, String name, Boolean bulb, Country country, String user) {
        this.id = id;
        this.name = name;
        this.bulb = bulb;
        this.country = country;
        this.user = user;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBulb() {
        return bulb;
    }

    public void setBulb(Boolean bulb) {
        this.bulb = bulb;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
