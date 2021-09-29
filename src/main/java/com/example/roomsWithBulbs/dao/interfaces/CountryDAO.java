package com.example.roomsWithBulbs.dao.interfaces;

import com.example.roomsWithBulbs.entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDAO {

    List<Country> getAll() throws SQLException;

    Country getById(Long id) throws SQLException;

}
