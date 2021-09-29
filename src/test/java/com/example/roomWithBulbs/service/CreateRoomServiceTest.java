package com.example.roomWithBulbs.service;

import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import com.example.roomsWithBulbs.entity.Room;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class CreateRoomServiceTest {


    @Test
    public void whenCreateRoomCalledVerified() throws SQLException {
        RoomDAO roomDAO = mock(RoomDAO.class);
        roomDAO.createRoom((Room) any());
        verify(roomDAO, times(1)).createRoom(Matchers.<Room>any());
    }
}
