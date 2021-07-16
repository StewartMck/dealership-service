package ca.smckinlay.dealership.service.services;

public interface SecurityService {

    String findLoggedInUsername();
    void login(String username, String password);

}
