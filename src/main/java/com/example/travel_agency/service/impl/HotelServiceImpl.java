package com.example.travel_agency.service.impl;

import com.example.travel_agency.dto.HotelDTO;
import com.example.travel_agency.entity.Hotel;
import com.example.travel_agency.repository.HotelRepo;
import com.example.travel_agency.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(HotelDTO hotelDTO) {
        Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
        hotelRepo.save(hotel);
    }

    @Override
    public void update(HotelDTO hotelDTO) {
        Optional<Hotel> optHotel = hotelRepo.findById(hotelDTO.getId());
        if (optHotel.isEmpty()) {
            throw new RuntimeException("Hotel not found with ID: " + hotelDTO.getId());
        }

        Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
        hotelRepo.save(hotel);
    }

    @Override
    public void delete(Long id) {
        if (!hotelRepo.existsById(id)) {
            throw new RuntimeException("Hotel not found with ID: " + id);
        }
        hotelRepo.deleteById(id);
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        if (hotel.isEmpty()) {
            throw new RuntimeException("Hotel not found with ID: " + id);
        }
        return modelMapper.map(hotel.get(), HotelDTO.class);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .toList();
    }
}
