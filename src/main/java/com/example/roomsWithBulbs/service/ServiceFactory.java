package com.example.roomsWithBulbs.service;


import java.util.HashMap;
import java.util.Map;

import static com.example.roomsWithBulbs.service.ServiceName.*;


public class ServiceFactory {
    private static ServiceFactory instance;
    private static final Map<String, Service> SERVICES = new HashMap<>();

    private ServiceFactory() {
    }

    static {
        SERVICES.put(MAIN_SERVICE, new GetUserIpDetailsService());
        SERVICES.put(ALL_ROOMS_SERVICE, new AllRoomsService());
        SERVICES.put(CREATE_ROOM_SERVICE, new CreateRoomService());
        SERVICES.put(ROOM_SERVICE, new RoomService());
        SERVICES.put(UPDATE_ROOM_SERVICE, new UpdateRoomService());
    }

    public Service getService(String serviceName) {
        Service service = SERVICES.get(MAIN_SERVICE);

        if (serviceName != null) {
            for (Map.Entry<String, Service> entry : SERVICES.entrySet()) {
                if (serviceName.equals(entry.getKey())) {
                    service = SERVICES.get(entry.getKey());
                }
            }
        }

        return service;
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }


}
