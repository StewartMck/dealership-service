package ca.smckinlay.dealership.service.data;

import ca.smckinlay.dealership.service.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

}
