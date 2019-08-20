package com.example.hotel.repository;


import com.example.hotel.model.BookingMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMenuRepository extends JpaRepository<BookingMenu,Long> {
}
