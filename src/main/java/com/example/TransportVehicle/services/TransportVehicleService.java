package com.example.TransportVehicle.services;

import com.example.TransportVehicle.entity.TransportVehicle;
import com.example.TransportVehicle.repositories.TransportRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransportVehicleService {
    public final TransportRepository transportRepository;

    public List<TransportVehicle> listTransport() {
        return transportRepository.findAll();
    }

    public List<TransportVehicle> searchTransport(String brand, String model, String category, String licensePlate, Integer year) {
        return transportRepository.searchTransport(brand, model, category, licensePlate, year);
    }

    public void saveTransportVehicle(TransportVehicle transportVehicle) {
        if (transportVehicle.getHasTrailer() == null) {
            transportVehicle.setHasTrailer(false);
        }
        if (transportRepository.existsByLicensePlate(transportVehicle.getLicensePlate())) {
            throw new IllegalArgumentException("Транспортное средство с таким государственным номером уже существует");
        }
        transportRepository.save(transportVehicle);
    }

    public void deleteTransport(Long id) {
        transportRepository.deleteById(id);
    }

    public TransportVehicle getTransportById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    public TransportVehicle updateTransportVehicle(Long id, TransportVehicle updatedTransportVehicle) {
        TransportVehicle existingTransportVehicle = transportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transport Vehicle not found with id: " + id));

        existingTransportVehicle.setBrand(updatedTransportVehicle.getBrand());
        existingTransportVehicle.setModel(updatedTransportVehicle.getModel());
        existingTransportVehicle.setCategory(updatedTransportVehicle.getCategory());
        existingTransportVehicle.setLicensePlate(updatedTransportVehicle.getLicensePlate());
        existingTransportVehicle.setVehicleType(updatedTransportVehicle.getVehicleType());
        existingTransportVehicle.setYear(updatedTransportVehicle.getYear());
        existingTransportVehicle.setHasTrailer(updatedTransportVehicle.getHasTrailer());
        if (existingTransportVehicle.getHasTrailer() == null) {
            existingTransportVehicle.setHasTrailer(false);
        }
        if (transportRepository.existsByLicensePlate(existingTransportVehicle.getLicensePlate())) {
            throw new IllegalArgumentException("Транспортное средство с таким государственным номером уже существует");
        }
        return transportRepository.save(existingTransportVehicle);
    }
}
