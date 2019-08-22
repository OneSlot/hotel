package com.example.hotel.aspect;


import com.example.hotel.model.Rooms;
import com.example.hotel.service.RoomService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;


@Aspect
@Component
public class HotelAspect {

  //  private Logger logger =LoggerFactory.getLogger(this.getClass());
    private final RoomService roomService;

    public HotelAspect(RoomService roomService) {
        this.roomService = roomService;
    }

    @Before("execution(* *.processRooms(..))")
    public void roomNumberAspect(JoinPoint joinPoint){
             Object [] args = joinPoint.getArgs();
             boolean roomNumberSame =false;

        Rooms room =(Rooms) args[0];
       // logger.info("Room number : "+room.getRoomsNumber());

        for(Rooms rooms:roomService.findAll()){
            if(rooms.getRoomsNumber().equals(room.getRoomsNumber())){
                roomNumberSame =true;
            }
        }

        if(roomNumberSame){
            throw new IllegalArgumentException(room.getRoomsNumber() +"Rooms are already existed.");
        }







        //    Optional<Rooms> room = Optional.of((Rooms) args[0]);
        /*
           if(!room.isPresent()){
               throw  new IllegalArgumentException("Room Not Found !");

           }

           */

           /*
             if(args[0] instanceof Rooms) {
                 room = (Rooms) args[0];

                 //    roomService.findAll().stream().filter(a->a.getRoomsNumber().equals(room.getId()));

             }

             */

             /*
             roomService.findAll()
                     .stream()
                     .filter(r -> !(r.getRoomsNumber().equals(room.get().getRoomsNumber())))
                     .findAny()
                      .orElseThrow(()-> new IllegalArgumentException(room.get().getId()+ "Room already existed."));

                      */
    }

    @Before("execution(* *.showRoomDetails(..))")
    public void roomNotfountAspect(JoinPoint joinPoint){
            Object [] args = joinPoint.getArgs();

          Rooms rooms=  roomService.findById((long)args[1]);

          if(rooms==null){
              throw  new EntityNotFoundException((long)args[1]+ " Not Found.");
          }
    }
}
