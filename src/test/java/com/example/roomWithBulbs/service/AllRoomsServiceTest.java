package com.example.roomWithBulbs.service;


import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import com.example.roomsWithBulbs.entity.Country;
import com.example.roomsWithBulbs.entity.Room;
import com.example.roomsWithBulbs.service.AllRoomsService;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class AllRoomsServiceTest {

    @Test
    public void whenPerform_thenReturnRoomsListAsJSON() throws SQLException, ServletException, IOException, ParseException {
        List<Room> roomList = new ArrayList<>();
        Room room1 = new Room(1L,"room1",true,new Country(1L,"country1","c1"),"user1");
        Room room2 = new Room(2L,"room2",true,new Country(2L,"country2","c2"),"user2");
        Room room3 = new Room(3L,"room3",true,new Country(3L,"country3","c3"),"user3");

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        AllRoomsService allRoomsService = mock(AllRoomsService.class);
        RoomDAO roomDAO = mock(RoomDAO.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(roomDAO.getAll()).thenReturn(roomList);
        allRoomsService.perform(request,response);


        verify(roomDAO,times(1));

    }

}
