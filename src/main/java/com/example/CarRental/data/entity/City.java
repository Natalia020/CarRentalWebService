package com.example.CarRental.data.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Address")
public class City implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_miasta")
    private Integer id_miasta;

    @NotNull
    @Column(name = "Nazwa_Miasta")
    private String Nazwa;
    @NotNull
    @Column(name = "Kod_Pocztowy")
    private String kodPocztowy;
    @NotNull
    @Column(name = "Ulica")
    private String ulica;
    @NotNull
    @Column(name = "nr_lokalu")
    private Integer nrLokalu;
}
