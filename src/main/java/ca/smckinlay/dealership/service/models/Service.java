package ca.smckinlay.dealership.service.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static final List<Service> bookings = new ArrayList<>();
    public static final Logger log = LoggerFactory.getLogger(Service.class);

    private String registration;
    private String model;
    private String customer;
    private String concerns;
    private String workshop;
    private Status status;

    public Service(String registration, String model, String customer, String concerns, String workshop, Status status) {
        this.registration = registration;
        this.model = model;
        this.customer = customer;
        this.concerns = concerns;
        this.workshop = workshop;
        this.status = status;
        bookings.add(this);
        log.info("BOOKINGS:, {}", bookings);
    }

    public static Service getService(String id) {
        log.info("ID FOR getService, {}", id);
        for(Service service : bookings) {
            if(service.getRegistration().equals(id)) {
                log.info("SERVICE. {}", service);
                return service;
            }
        }
        return null;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getConcerns() {
        return concerns;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service{" +
                "registration='" + registration + '\'' +
                ", model='" + model + '\'' +
                ", customer='" + customer + '\'' +
                ", concerns='" + concerns + '\'' +
                ", workshop='" + workshop + '\'' +
                ", status=" + status +
                '}';
    }
}