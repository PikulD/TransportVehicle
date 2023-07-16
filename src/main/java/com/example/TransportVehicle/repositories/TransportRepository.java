package com.example.TransportVehicle.repositories;

import com.example.TransportVehicle.entity.TransportVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepository extends JpaRepository<TransportVehicle, Long> {
    @Query("SELECT t FROM TransportVehicle t WHERE " +
            "COALESCE(:brand, '') = '' OR t.brand = :brand " +
            "AND COALESCE(:model, '') = '' OR t.model = :model " +
            "AND COALESCE(:category, '') = '' OR t.category = :category " +
            "AND COALESCE(:licensePlate, '') = '' OR t.licensePlate = :licensePlate " +
            "AND (:year = 0 OR t.year = :year)")
    List<TransportVehicle> searchTransport(@Param("brand") String brand,
                                           @Param("model") String model,
                                           @Param("category") String category,
                                           @Param("licensePlate") String licensePlate,
                                           @Param("year") int year);

    boolean existsByLicensePlate(String licensePlate);


}