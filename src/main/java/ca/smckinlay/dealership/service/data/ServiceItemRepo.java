package ca.smckinlay.dealership.service.data;

import ca.smckinlay.dealership.service.models.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepo extends JpaRepository<ServiceItem, String> {
}
