package com.micro1service.hotel.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.micro1service.hotel.entity.Hotel;
import com.micro1service.hotel.exception.ResoureceNoFoundException;
import com.micro1service.hotel.repository.HotelRepository;
import com.micro1service.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getByHotelId(String id)throws ResoureceNoFoundException {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResoureceNoFoundException("Hotel Not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public Hotel update(String id, Hotel hotel)throws ResoureceNoFoundException {
		Hotel hotelRes = hotelRepository.findById(id)
				.orElseThrow(() -> new ResoureceNoFoundException("Hotel Not found", HttpStatus.NOT_FOUND));
		hotel.setName(hotelRes.getName());
		hotel.setLocation(hotelRes.getLocation());
		hotel.setAbout(hotel.getAbout());
		hotelRepository.save(hotelRes);
		return hotelRes;
	}

	@Override
	public String DeleteHotel(String id)throws ResoureceNoFoundException {
		hotelRepository.findById(id)
				.orElseThrow(() -> new ResoureceNoFoundException("Hotel Not found", HttpStatus.NOT_FOUND));
		hotelRepository.deleteById(id);
		;
		return "hotel deleted successfully";
	}

}
