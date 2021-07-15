package ca.smckinlay.dealership.service.services;

import ca.smckinlay.dealership.service.models.User;

public interface UserService {

    User findByUsername(String username);
}
