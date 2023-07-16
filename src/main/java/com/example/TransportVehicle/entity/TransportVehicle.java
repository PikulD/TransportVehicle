package com.example.TransportVehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "transportVehicles")
@NoArgsConstructor
public class TransportVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String category;
    @Column(name = "licensePlate", unique = true)
    private String licensePlate;
    private String vehicleType;
    private Integer year;
    private Boolean hasTrailer;


}

