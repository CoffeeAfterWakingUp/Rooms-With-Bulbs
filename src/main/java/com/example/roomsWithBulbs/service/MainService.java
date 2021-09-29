package com.example.roomsWithBulbs.service;

import com.example.roomsWithBulbs.dao.impl.CountryDAOImpl;
import com.example.roomsWithBulbs.dao.interfaces.CountryDAO;
import com.example.roomsWithBulbs.entity.Country;
import com.example.roomsWithBulbs.entity.UserIpDetails;
import com.example.roomsWithBulbs.util.IpAddressDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


public class MainService implements Service {
    private final CountryDAO countryDAO = new CountryDAOImpl();
    private static final String ERROR_MESSAGE = "Sorry! Right now, our services are not working(";


    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        UserIpDetails details = IpAddressDetails.getUserIpDetails();
        setMessage(request,details);
        getCountryList(request);
        getUserLocalAddress(request);
        request.setAttribute("details",details);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }


    private void getUserLocalAddress(HttpServletRequest request) throws UnknownHostException {
        String localAddress = IpAddressDetails.getUserLocalAddress();
        request.setAttribute("localAddress", localAddress);
    }

    private void setMessage(HttpServletRequest request, UserIpDetails userIpDetails) {
        String ipAddress = userIpDetails.getIp();
        String message = "Welcome, ";
        if (ipAddress == null) {
            message = ERROR_MESSAGE;
        }
        message += ipAddress + "!";
        request.setAttribute("message", message);
    }

    private void getCountryList(HttpServletRequest request) throws SQLException {
        List<Country> countryList = countryDAO.getAll();
        request.setAttribute("countryList", countryList);
    }
}
