package com.example.roomWithBulbs.util;


import com.example.roomsWithBulbs.util.IpAddressDetails;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IpAddressDetailsTest {
    private final static String MY_LOCAL_ADDRESS = "192.168.56.1";


    @Test
    public void getUserLocalAddressTest() throws UnknownHostException {
        String localAddress = IpAddressDetails.getUserLocalAddress();
        assertEquals(MY_LOCAL_ADDRESS,localAddress);
    }



}
