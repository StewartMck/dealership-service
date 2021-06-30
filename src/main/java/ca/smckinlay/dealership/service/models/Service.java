package ca.smckinlay.dealership.service.models;

public class Service {

    private String registration;
    private String model;
    private String customer;
    private Status status;

    public Service(String registration, String model, String customer, Status status) {
        this.registration = registration;
        this.model = model;
        this.customer = customer;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
