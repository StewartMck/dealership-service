package ca.smckinlay.dealership.service.services;

import org.springframework.stereotype.Service;

@Service
public class HTTPStatusErrorServiceImpl implements HTTPStatusErrorService {

    @Override
    public String getHTTPStatusMsg(int statusCode) {
        switch (statusCode) {
            case 400: {
                return "There was a Bad Request";
            }
            case 401: {
                return "You need to login to view this page";
            }
            case 403: {
                return "You are not authorized to view this page";
            }
            case 404: {
                return "The Resource was not found";
            }
            case 500: {
                return "There was an Internal Server Error";
            }
            default:
                return "An error occurred!";
        }
    }
}