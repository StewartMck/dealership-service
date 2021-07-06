package ca.smckinlay.dealership.service.services;

import ca.smckinlay.dealership.service.data.ServiceItemRepo;
import ca.smckinlay.dealership.service.models.ServiceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceModel {

    private static final Logger log = LoggerFactory.getLogger(ServiceModel.class);
    private final ServiceItemRepo serviceItemRepo;

    @Autowired
    public ServiceModel(ServiceItemRepo serviceItemRepo) {
        this.serviceItemRepo = serviceItemRepo;
    }

    public List<ServiceItem> getAllBookings(){
        return serviceItemRepo.findAll(Sort.by("status").descending().and(Sort.by("date").descending()));
    }

    public ServiceItem getBooking(String id) {
        log.info("GET_SERVICE {}", serviceItemRepo.getById(id));
        return serviceItemRepo.getById(id);
    }

    public void addUpdateBooking(ServiceItem serviceItem){
        serviceItemRepo.save(serviceItem);
    }

}
