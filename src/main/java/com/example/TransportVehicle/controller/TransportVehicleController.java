package com.example.TransportVehicle.controller;

import com.example.TransportVehicle.entity.TransportVehicle;
import com.example.TransportVehicle.services.TransportVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TransportVehicleController {
    private final TransportVehicleService transportVehicleService;

    @GetMapping("/")
    public String transports(Model entity) {
        entity.addAttribute("transports", transportVehicleService.listTransport());
        return "vehicles";
    }

    @GetMapping("/search")
    public String searchTransport(@RequestParam(required = false) String brand,
                                  @RequestParam(required = false) String model,
                                  @RequestParam(required = false) String category,
                                  @RequestParam(required = false) String licensePlate,
                                  @RequestParam(required = false) int year, Model entity) {
        entity.addAttribute("transports", transportVehicleService.searchTransport(brand, model, category, licensePlate, year));
        return "vehicles";

    }

    @GetMapping("/add")
    public String createTransportForm() {
        return "add";
    }

    @PostMapping("/add")
    public String createTransport(TransportVehicle transportVehicle, Model model) {
        try {
            transportVehicleService.saveTransportVehicle(transportVehicle);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "add";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTransportVehicle(@PathVariable Long id, TransportVehicle updatedTransportVehicle, Model model) {
        try {
            transportVehicleService.updateTransportVehicle(id, updatedTransportVehicle);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "edit";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTransportForm(@PathVariable("id") Long id, Model model) {
        TransportVehicle transport = transportVehicleService.getTransportById(id);
        model.addAttribute("transport", transport);
        return "edit";
    }
    /*@PostMapping("/add")
    public String editTransport (TransportVehicle transportVehicle){
        transportVehicleService.saveTransportVehicle(transportVehicle);
        return "redirect:/";
    }*/
}
