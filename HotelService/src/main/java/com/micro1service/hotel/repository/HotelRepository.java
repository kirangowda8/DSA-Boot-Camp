package com.micro1service.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro1service.hotel.entity.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel , String>{

}
