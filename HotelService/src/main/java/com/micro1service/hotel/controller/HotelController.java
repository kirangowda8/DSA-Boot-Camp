package com.micro1service.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1service.hotel.entity.Hotel;
import com.micro1service.hotel.exception.ResoureceNoFoundException;
import com.micro1service.hotel.service.HotelService;

@RestController
@RequestMapping("/api/hotel-service")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.createHotel(hotel),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getALl(){
		return  new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getById(@PathVariable String id)throws ResoureceNoFoundException {
		return new ResponseEntity<Hotel>(hotelService.getByHotelId(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String id) throws ResoureceNoFoundException{
		return new ResponseEntity<Hotel>(hotelService.update(id, hotel), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteHotel(@PathVariable String id)throws ResoureceNoFoundException {
		return hotelService.DeleteHotel(id);
	}
	
}

