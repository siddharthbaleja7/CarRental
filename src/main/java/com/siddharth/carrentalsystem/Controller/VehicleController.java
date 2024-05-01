package com.siddharth.carrentalsystem.Controller;

import com.siddharth.carrentalsystem.Dtos.VehicleRequestDto;
import com.siddharth.carrentalsystem.Dtos.VehicleResponseDto;
import com.siddharth.carrentalsystem.Service.VehicleService;
import com.siddharth.carrentalsystem.models.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    // create
//    @PostMapping
//    public ResponseEntity<Void> createVehicle(@RequestBody VehicleRequestDto requestDTO) {
//        vehicleService.createVehicle(requestDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<Vehicles> createVehicle(@RequestBody VehicleRequestDto requestDTO) {
        Vehicles createdVehicle = vehicleService.createVehicle(requestDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }


    // update
//    @PutMapping("/{vehicleId}")
//    public ResponseEntity<Void> updateVehicle(@PathVariable int vehicleId, @RequestBody VehicleRequestDto requestDTO) {
//        vehicleService.updateVehicle(vehicleId, requestDTO);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PutMapping("/{vehicleId}")
    public ResponseEntity<Vehicles> updateVehicle(@PathVariable int vehicleId, @RequestBody VehicleRequestDto requestDTO) {
        Vehicles updatedVehicle = vehicleService.updateVehicle(vehicleId, requestDTO);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }



    // delete

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Vehicles> deleteVehicle(@PathVariable int vehicleId) {
        Vehicles deletedVehicle = vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(deletedVehicle, HttpStatus.NO_CONTENT);
    }

    // read
    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicles> getVehicleById(@PathVariable int vehicleId) {
        Vehicles vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(vehicle);
    }


//    @GetMapping("/branch/{branchId}")
//    public ResponseEntity<List<VehicleResponseDto>> getVehiclesByBranch(@PathVariable int branchId) {
//        List<VehicleResponseDto> vehicles = vehicleService.getVehiclesByBranch(branchId);
//        return ResponseEntity.ok(vehicles);
//    }
//
//    @GetMapping("/type/{type}")
//    public ResponseEntity<List<VehicleResponseDto>> getVehiclesByType(@PathVariable String type) {
//        List<VehicleResponseDto> vehicles = vehicleService.getVehiclesByType(type);
//        return ResponseEntity.ok(vehicles);
//    }
//
//    @GetMapping("/availability/{status}")
//    public ResponseEntity<List<VehicleResponseDto>> getVehiclesByAvailability(@PathVariable boolean status) {
//        List<VehicleResponseDto> vehicles = vehicleService.getVehiclesByAvailability(status);
//        return ResponseEntity.ok(vehicles);
//    }
}