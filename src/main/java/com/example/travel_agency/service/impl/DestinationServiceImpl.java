package com.example.travel_agency.service.impl;

import com.example.travel_agency.dto.DestinationDTO;
import com.example.travel_agency.entity.Destination;
import com.example.travel_agency.repository.DestinationRepo;
import com.example.travel_agency.service.DestinationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepo destinationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(DestinationDTO destinationDTO) {
        Destination destination = modelMapper.map(destinationDTO, Destination.class);
        destinationRepository.save(destination);
    }

    @Override
    public void update(DestinationDTO destinationDTO) {
        Optional<Destination> optDestination = destinationRepository.findById(destinationDTO.getId());
        if (optDestination.isEmpty()) {
            throw new RuntimeException("Destination not found with ID: " + destinationDTO
                    .getId());
        }
        Destination destination = modelMapper.map(destinationDTO, Destination.class);
        destinationRepository.save(destination);
    }

    @Override
    public void delete(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new RuntimeException("Destination not found with ID: " + id);
        }
        destinationRepository.deleteById(id);
    }

    @Override
    public List<DestinationDTO> getAllDestinations() {
        List<Destination> destinations = destinationRepository.findAll();
        return destinations.stream()
                .map(destination -> modelMapper.map(destination, DestinationDTO.class))
                .toList();
    }

    @Override
    public DestinationDTO getDestinationById(Long id) {
        Optional<Destination> destination = destinationRepository.findById(id);
        if (destination.isEmpty()) {
            throw new RuntimeException("Destination not found with ID: " + id);
        }
        return modelMapper.map(destination.get(), DestinationDTO.class);
    }
}
