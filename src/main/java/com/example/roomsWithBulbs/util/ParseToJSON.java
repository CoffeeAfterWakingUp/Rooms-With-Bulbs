package com.example.roomsWithBulbs.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseToJSON {
    private final static Logger LOGGER = LogManager.getLogger();


    public static JSONObject parseStringToJSON(String jsonAsString){
        JSONObject json = null;
        try {
            json = new JSONObject(jsonAsString);
        }catch (JSONException err){
            LOGGER.error("Error", err.toString());
        }
        return json;
    }
}
