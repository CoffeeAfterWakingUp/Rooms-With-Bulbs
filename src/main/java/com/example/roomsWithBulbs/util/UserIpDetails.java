package com.example.roomsWithBulbs.util;

import java.math.BigDecimal;

public class UserIpDetails {
    private String ip;
    private String city;
    private String continent;
    private String countryCode;
    private String countryName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String org;
    private String timezone;
    private String postalCode;

    public UserIpDetails() {
    }

    public UserIpDetails(String ip, String city, String continent, String countryCode, String countryName, BigDecimal latitude, BigDecimal longitude, String org, String timezone, String postalCode) {
        this.ip = ip;
        this.city = city;
        this.continent = continent;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.org = org;
        this.timezone = timezone;
        this.postalCode = postalCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
