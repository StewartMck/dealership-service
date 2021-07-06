package ca.smckinlay.dealership.service.models;

import ca.smckinlay.dealership.service.util.ValidationMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "SERVICE")
public class ServiceItem {

    public static final Logger log = LoggerFactory.getLogger(ServiceItem.class);

    @Id
    @NotBlank(message = ValidationMessages.REGISTRATION)
    @Column(name = "REGISTRATION")
    private String registration;

    @Column(name = "DATE")
    private Timestamp date;

    @NotBlank(message = ValidationMessages.MODEL)
    @Column(name = "MODEL")
    private String model;

    @NotBlank(message = ValidationMessages.CUSTOMER)
    @Column(name = "CUSTOMER")
    private String customer;

    @NotBlank(message = ValidationMessages.CONCERNS)
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
        this.date = new Timestamp(System.currentTimeMillis());
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate() {
        this.date = new Timestamp(System.currentTimeMillis());
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
