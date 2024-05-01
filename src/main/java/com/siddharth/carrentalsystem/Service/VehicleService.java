package com.siddharth.carrentalsystem.Service;

import com.siddharth.carrentalsystem.Dtos.VehicleRequestDto;
import com.siddharth.carrentalsystem.Dtos.VehicleResponseDto;
import com.siddharth.carrentalsystem.Repository.VehicleRepository;
import com.siddharth.carrentalsystem.models.Branch;
import com.siddharth.carrentalsystem.models.Vehicles;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    // create
    public Vehicles createVehicle(VehicleRequestDto requestDto) {
        Vehicles vehicle = new Vehicles();
        mapDtotoVehicle(requestDto, vehicle);
        return vehicleRepository.save(vehicle);
    }

    //update
    public Vehicles updateVehicle(int vehicleId, VehicleRequestDto requestDTO) {
        Optional<Vehicles> optionalVehicle = vehicleRepository.findById(vehicleId);
        if (optionalVehicle.isPresent()) {
            Vehicles vehicle = optionalVehicle.get();
            // Update the vehicle entity with data from the requestDTO
            mapDtotoVehicle(requestDTO, vehicle);
            // Save the updated vehicle entity
            return vehicleRepository.save(vehicle);
        } else {
            // Handle the case when the vehicle with the given ID is not found
            throw new EntityNotFoundException("Vehicle with ID " + vehicleId + " not found");
        }
    }


    //delete
//    public void deleteVehicle(int vehicleId){
//        vehicleRepository.deleteById(vehicleId);
//    }
    public Vehicles deleteVehicle(int vehicleId) {
        Optional<Vehicles> optionalVehicle = vehicleRepository.findById(vehicleId);
        if (optionalVehicle.isPresent()) {
            Vehicles deletedVehicle = optionalVehicle.get();
            vehicleRepository.delete(deletedVehicle);
            return deletedVehicle;
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicleId + " not found");
        }
    }

    //read
    public Vehicles getVehicleById(int vehicleId) {
        Optional<Vehicles> optionalVehicles = vehicleRepository.findById(vehicleId);
        if (optionalVehicles.isPresent()) {
            return optionalVehicles.get();
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicleId + " not found");
        }
    }



//    public List<VehicleResponseDto> getVehiclesByBranch(int branchId){
//        List<Vehicles> vehicles = vehicleRepository.findByBranch(branchId);
//        return mapVehicleListToDtoList(vehicles);
//    }
//
//    public List<VehicleResponseDto> getVehiclesByType(String type){
//        List<Vehicles> vehicles = vehicleRepository.findByType(type);
//        return mapVehicleListToDtoList(vehicles);
//    }
//
//    public List<VehicleResponseDto> getVehiclesByAvailability(boolean status){
//        List<Vehicles> vehicles = vehicleRepository.findByStatus(status);
//        return mapVehicleListToDtoList(vehicles);
//    }

    private void mapDtotoVehicle(VehicleRequestDto requestDto,Vehicles vehicle){
        vehicle.setVehicleId(requestDto.getVehicleId());
        vehicle.setMake(requestDto.getMake());
        vehicle.setModel(requestDto.getModel());
        vehicle.setYear(requestDto.getYear());
        vehicle.setLicensePlate(requestDto.getLicensePlate());
        vehicle.setCurrentMileage(requestDto.getCurrentMileage());
        // branch is remaining
    }
    private VehicleResponseDto mapVehicleToDto(Vehicles vehicle) {
        VehicleResponseDto responseDto = new VehicleResponseDto();
        responseDto.setVehicleId(vehicle.getVehicleId());
        responseDto.setMake(vehicle.getMake());
        responseDto.setModel(vehicle.getModel());
        responseDto.setYear(vehicle.getYear());
        responseDto.setLicensePlate(vehicle.getLicensePlate());
        responseDto.setCurrentMileage(vehicle.getCurrentMileage());
        // You need to handle setting branch here if it's added to the DTO
        return responseDto;
    }

    private List<VehicleResponseDto> mapVehicleListToDtoList(List<Vehicles> vehicles) {
        List<VehicleResponseDto> dtoList = new ArrayList<>();
        for (Vehicles vehicle : vehicles) {
            dtoList.add(mapVehicleToDto(vehicle));
        }
        return dtoList;
    }

}



//        vehicle.setVehicleId(requestDto.getVehicleId());
//        vehicle.setMake(requestDto.getMake());;
//        vehicle.setModel(requestDto.getModel());
//        vehicle.setYear(requestDto.getYear());
//        vehicle.setLicensePlate(requestDto.getLicensePlate());
//        vehicle.setCurrentMileage(requestDto.getCurrentMileage());
// dont know the branch
//        vehicle.setBranch(new Branch(requestDto.getBranchId()));


//    public void updateVehicle(int VehicleId,VehicleRequestDto requestDto){
//        Optional<Vehicles> optionalVehicle = vehicleRepository.findById(VehicleId);
//        if(optionalVehicle.isPresent()){
//            Vehicles vehicle = optionalVehicle.get();
//            mapDtotoVehicle(requestDto,vehicle);
////            vehicle.setMake(requestDto.getMake());
////            vehicle.setModel(requestDto.getModel());
////            vehicle.setYear(requestDto.getYear());
////            vehicle.setLicensePlate(requestDto.getLicensePlate());
////            vehicle.setCurrentMileage(requestDto.getCurrentMileage());
//            // branch is remaining
//            vehicleRepository.save(vehicle);
//        }
//        else{
//            // exception
//        }
//    }


//public VehicleResponseDto getVehicleById(int vehicleId){
//        Optional<Vehicles> optionalVehicles = vehicleRepository.findById(vehicleId);
//        if(optionalVehicles.isPresent()){
//            Vehicles vehicle = optionalVehicles.get();
//            return mapVehicleToDto(vehicle);
//        }
//        else{
//            return null;
//            // exception
//        }
//    }