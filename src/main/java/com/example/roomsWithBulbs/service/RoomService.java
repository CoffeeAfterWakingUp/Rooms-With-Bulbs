package com.example.roomsWithBulbs.service;

import com.example.roomsWithBulbs.dao.impl.RoomDAOImpl;
import com.example.roomsWithBulbs.dao.interfaces.RoomDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class RoomService implements Service{
    private final RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Long id = Long.valueOf(request.getParameter("id"));
        JSONObject jsonObject = new JSONObject(roomDAO.getById(id));
        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toString());
    }
}
