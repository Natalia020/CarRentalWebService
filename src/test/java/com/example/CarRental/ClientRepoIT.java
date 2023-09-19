package com.example.CarRental;

import com.example.CarRental.data.Service.ClientService;
import com.example.CarRental.data.entity.Client;
import com.example.CarRental.data.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepoIT {
    @Autowired
    private ClientRepository clientRepository;
    private ClientService clientService;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void addUserTest() {

        Client clients = Client.builder()
                .Id(3)
                .role("ROLE_USER")
                .enabled(1)
                .Name("Marek")
                .LastName("Nowak")
                .Email("marek@gmail.com")
                .Password("123")
                .build();
        clientRepository.save(clients);

        Assertions.assertThat(clients.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void updateUserTest() {
        Client clients = clientRepository.findById(3).get();
        clients.setEmail("arek@gmail.com");
        Client updatedClient = clientRepository.save(clients);
        Assertions.assertThat(updatedClient.getEmail()).isEqualTo("arek@gmail.com");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void deleteUserTest() {
        clientRepository.deleteById(3);

        Assertions.assertThat(clientRepository.count()).isEqualTo(2);

    }
}