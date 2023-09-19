package com.example.CarRental.data.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client implements Serializable {

    @Id
    @NotNull
    private Integer Id;
    @NotNull
    @Column(name = "Email")
    private String Email;
    @NotNull
    @Column(name = "PhoneNo")
    private String phoneNo;
    @Column(name = "Pesel")
    private String pesel;
    @Column(name = "PassportNo")
    private String PassportNo;
    @NotNull
    @Column(name = "Password")
    private String Password;
    @NotNull
    @Column(name = "Name")
    private String Name;
    @NotNull
    @Column(name = "LastName")
    private String LastName;
    @NotNull
    @Column(name = "enabled")
    private Integer enabled;
    @NotNull
    @Column(name = "role")
    private String role;

    public Client(Integer id, String email, String phoneNo, String pesel, String password, String name, String lastName, Integer enabled, String role) {
    }
}
