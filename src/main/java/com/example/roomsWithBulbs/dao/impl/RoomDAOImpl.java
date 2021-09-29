package com.example.roomsWithBulbs.dao.impl;

import com.example.roomsWithBulbs.dao.connection.ConnectionPool;
import com.example.roomsWithBulbs.dao.interfaces.CountryDAO;
import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import com.example.roomsWithBulbs.entity.Country;
import com.example.roomsWithBulbs.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private final static String GET_ALL = "SELECT * FROM room";
    private final static String GET_BY_ID = "SELECT * FROM room WHERE r_id = ?";
    private final static String CREATE_ROOM = "INSERT INTO room(r_name,bulb,country_id,user) VALUES(?,?,?,?)";
    private final static String UPDATE_ROOM = "UPDATE room SET r_name = ?, bulb = ?, country_id = ? WHERE r_id = ?";


    private ConnectionPool connectionPool;
    private Connection connection;
    private final CountryDAO countryDAO = new CountryDAOImpl();

    @Override
    public List<Room> getAll() throws SQLException {
        List<Room> roomList = new ArrayList<>();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Room room = new Room();
                setRoomDetails(room,resultSet);
                roomList.add(room);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return roomList;
    }

    @Override
    public Room getById(Long id) throws SQLException {
        Room room = new Room();
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                setRoomDetails(room,resultSet);
            }
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return room;
    }

    @Override
    public void createRoom(Room room) throws SQLException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ROOM)){
            preparedStatement.setString(1,room.getName());
            preparedStatement.setBoolean(2,room.getBulb());
            preparedStatement.setLong(3,room.getCountry().getId());
            preparedStatement.setString(4,room.getUser());
            preparedStatement.executeUpdate();
        }finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void updateRoom(Room room, Long id) throws SQLException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM)){
            preparedStatement.setString(1,room.getName());
            preparedStatement.setBoolean(2,room.getBulb());
            preparedStatement.setLong(3,room.getCountry().getId());
            preparedStatement.setLong(4,id);
            preparedStatement.executeUpdate();
        }finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private void setRoomDetails(Room room, ResultSet resultSet) throws SQLException{
        room.setId(resultSet.getLong(1));
        room.setName(resultSet.getString(2));
        room.setBulb(resultSet.getBoolean(3));
        Country country = countryDAO.getById(resultSet.getLong(4));
        room.setCountry(country);
        room.setUser(resultSet.getString(5));
    }
}
