package com.example.roomsWithBulbs.dao.impl;

import com.example.roomsWithBulbs.dao.connection.ConnectionPool;
import com.example.roomsWithBulbs.dao.interfaces.CountryDAO;
import com.example.roomsWithBulbs.entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {
    private final static String GET_ALL = "SELECT * FROM country";
    private final static String GET_BY_ID = "SELECT * FROM country WHERE c_id = ?";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Country> getAll() throws SQLException {
        List<Country> countryList = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                setCountryDetails(country, resultSet);
                countryList.add(country);
            }
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return countryList;
    }

    @Override
    public Country getById(Long id) throws SQLException {
        Country country = new Country();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                setCountryDetails(country, resultSet);
            }
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return country;
    }

    private void setCountryDetails(Country country, ResultSet resultSet) throws SQLException {
        country.setId(resultSet.getLong(1));
        country.setName(resultSet.getString(2));
        country.setCode(resultSet.getString(3));
    }
}
