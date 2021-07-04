package ca.smckinlay.dealership.service.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SERVICE")
public class ServiceItem {

    public static final Logger log = LoggerFactory.getLogger(ServiceItem.class);

    @Id
    @NotBlank(message = "Registration is mandatory")
    @Column(name = "REGISTRATION")
    private String registration;

    @NotBlank(message = "Model is mandatory")
    @Column(name = "MODEL")
    private String model;

    @NotBlank(message = "Customer is mandatory")
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "CONCERNS")
    private String concerns;
    @Column(name = "WORKSHOP")
    private String workshop;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    public ServiceItem() {
    }

    public ServiceItem(String registration, String model, String customer, String concerns, String workshop, Status status) {
        this.registration = registration;
        this.model = model;
        this.customer = customer;
        this.concerns = concerns;
        this.workshop = workshop;
        this.status = status;
        log.info("NEW ITEM:, {}", this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceItem)) return false;

        ServiceItem service = (ServiceItem) o;

        return registration.equals(service.registration);
    }

    @Override
    public int hashCode() {
        return registration.hashCode();
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
