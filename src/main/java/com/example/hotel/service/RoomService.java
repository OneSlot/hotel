package com.example.hotel.service;

import com.example.hotel.model.Rooms;

import java.util.List;

public interface RoomService {

    Rooms create(Rooms rooms);
    Rooms findById(long id);
    List<Rooms> findAll();
}
