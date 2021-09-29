package com.example.roomWithBulbs.service;

import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import com.example.roomsWithBulbs.entity.Room;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

import java.sql.SQLException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UpdateRoomServiceTest {

    @Test
    public void whenUpdateRoomCalledVerified() throws SQLException {
        RoomDAO roomDAO = mock(RoomDAO.class);
        roomDAO.updateRoom((Room) any(), anyLong());
        verify(roomDAO, times(1)).updateRoom(Matchers.<Room>any(), anyLong());
    }

}
