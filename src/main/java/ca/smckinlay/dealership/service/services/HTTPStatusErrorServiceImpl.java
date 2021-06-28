package ca.smckinlay.dealership.service.services;

import org.springframework.stereotype.Service;

@Service
public class HTTPStatusErrorServiceImpl implements HTTPStatusErrorService {

    @Override
    public String getHTTPStatusMsg(int statusCode) {
        switch (statusCode) {
            case 400: {
                return "Http Error Code: 400. Bad Request";
            }
            case 401: {
                return "Http Error Code: 401. Unauthorized";
            }
            case 404: {
                return "Http Error Code: 404. Resource not found";
            }
            case 500: {
                return "Http Error Code: 500. Internal Server Error";
            }
            default:
                return "An error occured!";
        }
    }
}