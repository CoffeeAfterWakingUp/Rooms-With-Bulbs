package com.example.roomsWithBulbs.util;

import com.example.roomsWithBulbs.entity.UserIpDetails;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class IpAddressDetails {
    private static final UserIpDetails userIpDetails = new UserIpDetails();
    private final static String IP_GEOLOCATION_URL = "https://ipgeolocation.abstractapi.com/v1/?api_key=c0ae6a1130864c39b45be232da5247ce";


    public static UserIpDetails getUserIpDetails() throws IOException {
        setUserIpDetails();
        return userIpDetails;
    }

    public static String getUserLocalAddress() throws UnknownHostException {
        InetAddress localAddress = InetAddress.getLocalHost();
        return localAddress.getHostAddress();
    }


    private static JSONObject parseIpDetailsToJSON() throws IOException {
        String ipDetails = parseIpDetails();
        return ParseToJSON.parseStringToJSON(ipDetails);
    }

    private static String parseIpDetails() throws IOException {
        URL serviceUrl = new URL(IP_GEOLOCATION_URL);
        BufferedReader in = new BufferedReader(new InputStreamReader(serviceUrl.openStream()));
        String ipDetails = in.readLine();
        in.close();
        return ipDetails;
    }

    private static void setUserIpDetails() throws IOException {
        JSONObject json = parseIpDetailsToJSON();
        userIpDetails.setIp((String) json.get("ip_address"));
        userIpDetails.setCity(json.getString("city"));
        userIpDetails.setCountryName(json.getString("country"));
        userIpDetails.setCountryCode(json.getString("country_code"));
        userIpDetails.setContinent(json.getString("continent"));
        userIpDetails.setLatitude(json.getBigDecimal("latitude"));
        userIpDetails.setLongitude(json.getBigDecimal("longitude"));
        userIpDetails.setTimezone(json.getJSONObject("timezone").getString("name"));
        userIpDetails.setPostalCode(String.valueOf(json.get("postal_code")));
        userIpDetails.setOrg(String.valueOf(json.getJSONObject("connection").get("organization_name")));
    }

}
