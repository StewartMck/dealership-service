package ca.smckinlay.dealership.service.services;

import ca.smckinlay.dealership.service.data.VehicleRepo;
import ca.smckinlay.dealership.service.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModel  {

    @Autowired
    private VehicleRepo vehicleRepo;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll(Sort.by("name").ascending());
    }

}
