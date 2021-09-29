package com.example.roomsWithBulbs.service;

import com.example.roomsWithBulbs.dao.impl.CountryDAOImpl;
import com.example.roomsWithBulbs.dao.impl.RoomDAOImpl;
import com.example.roomsWithBulbs.dao.interfaces.CountryDAO;
import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import com.example.roomsWithBulbs.entity.Country;
import com.example.roomsWithBulbs.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CreateRoomService implements Service{
    private final RoomDAO roomDAO = new RoomDAOImpl();
    private final CountryDAO countryDAO = new CountryDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String name = request.getParameter("name");
        Boolean bulb = setBulb(request.getParameter("bulb"));
        Long countryId = Long.valueOf(request.getParameter("country"));
        String user = request.getParameter("user");
        Country country = countryDAO.getById(countryId);
        Room room = new Room();
        room.setName(name);
        room.setCountry(country);
        room.setUser(user);
        room.setBulb(bulb);
        roomDAO.createRoom(room);
    }

    private Boolean setBulb(String bulbAsString){
        return bulbAsString.equals("on");
    }


}
