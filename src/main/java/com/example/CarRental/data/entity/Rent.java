package com.example.CarRental.data.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rent implements Serializable {

    @Id
    @NotNull
    @GeneratedValue
    private Long Id;

    @NotNull
    private LocalDate rentDate;
    @NotNull
    private LocalDate returnDate;

    @ManyToOne
    private Client driver;

    @ManyToOne
    private Car car;

    @ManyToOne
    private City city;

    @NotNull
    private Float price;
    @NotNull
    private String status;

    @Transient
    public String getAddress() {
        if (city == null || Id == null) return null;

        return city.getKodPocztowy() + " " + city.getNazwa() +", "+city.getUlica()+" " + city.getNrLokalu();
    }
    @Transient
    public String getDriverData() {
        if (driver == null || Id == null) return null;

        return driver.getEmail()+": "+driver.getName() + " "+ driver.getLastName()+ ", " + driver.getPesel() + ", " + driver.getPassportNo();
    }
    @Transient
    public String getCarName() {
        if (car == null || Id == null) return null;

        return car.getRegistrationNumber()+", "+car.getModel();
    }
}
