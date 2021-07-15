package ca.smckinlay.dealership.service.data;

import ca.smckinlay.dealership.service.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
