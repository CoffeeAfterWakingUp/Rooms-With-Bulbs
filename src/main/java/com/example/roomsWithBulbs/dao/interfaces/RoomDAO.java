package com.example.roomsWithBulbs.dao.interfaces;

import com.example.roomsWithBulbs.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {

    List<Room> getAll() throws SQLException;

    Room getById(Long id) throws SQLException;

    void createRoom(Room room) throws SQLException;

    void updateRoom(Room room, Long id) throws SQLException;
}
