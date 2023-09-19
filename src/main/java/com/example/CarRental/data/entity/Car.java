package com.example.CarRental.data.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
    @Id
    @NotNull
    @Column(name = "VIN")
    private Long id;
    @NotNull
    @Column(name = "Numer_rejestracyjny")
    public String registrationNumber;
    @NotNull
    @Column(name = "Model")
    private String model;
    @NotNull
    @Column(name = "Price")
    public float price;
    @NotNull
    @Column(name = "Mileage")
    private int mileage;
//    @NotNull
    @Column(name = "Paliwo")
    private String paliwo;
//    @NotNull
    @Column(name = "pojSilnika")
    private Float pojSilnika;
//    @NotNull
    @Column(name = "lMiejsc")
    private int lMiejsc;
    /*@NotNull*/
    @Column(name = "skrzBieg")
    private String skrzBieg;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;
    private String zdjecie;

    @Transient
    public String getZdjecieImagePath() {
        if (zdjecie == null || id == null) return null;

        return "/user-photos/" + id + "/" + zdjecie;
    }
    @Transient
    public String getCityName() {
        if (city == null || id == null) return null;

        return city.getNazwa();
    }
}
