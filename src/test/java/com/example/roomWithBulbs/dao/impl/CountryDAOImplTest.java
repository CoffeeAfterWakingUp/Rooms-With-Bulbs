package com.example.roomWithBulbs.dao.impl;

import com.example.roomsWithBulbs.dao.connection.ConnectionPool;
import com.example.roomsWithBulbs.dao.impl.CountryDAOImpl;
import com.example.roomsWithBulbs.dao.interfaces.CountryDAO;
import com.example.roomsWithBulbs.entity.Country;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CountryDAOImplTest {


    @Test
    public void testGetAll() throws SQLException {
        CountryDAO countryDAO = Mockito.mock(CountryDAOImpl.class);
        ConnectionPool connectionPool = Mockito.mock(ConnectionPool.class);
        Connection connection = Mockito.mock(Connection.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
        when(countryDAO.getAll()).thenReturn(new ArrayList<Country>());
        when(connectionPool.takeConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        verify(connectionPool, times(1));
    }


}
