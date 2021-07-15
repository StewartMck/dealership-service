package ca.smckinlay.dealership.service.data;

import ca.smckinlay.dealership.service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
