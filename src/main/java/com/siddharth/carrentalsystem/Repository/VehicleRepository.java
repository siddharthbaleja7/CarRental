package com.siddharth.carrentalsystem.Repository;

import com.siddharth.carrentalsystem.models.Branch;
import com.siddharth.carrentalsystem.models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Integer> {
//    @Override
//    Vehicles save(Vehicles vehicles);
    //    @Override
//    Optional<Vehicles> findById(Integer integer);
//
//    List<Vehicles> findByType(String type);
//    List<Vehicles> findByBranch(int branchId);
//    List<Vehicles> findByStatus(boolean status);

}
