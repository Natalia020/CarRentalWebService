package com.example.CarRental.data.Service;

import com.example.CarRental.data.entity.Car;
import com.example.CarRental.data.entity.City;
import com.example.CarRental.data.entity.Client;
import com.example.CarRental.data.entity.Rent;
import com.example.CarRental.data.repository.CarRepository;
import com.example.CarRental.data.repository.ClientRepository;
import com.example.CarRental.data.repository.RentRepository;
import com.example.CarRental.data.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Client client = (Client)authentication.getPrincipal();
    int userId = client.getId();*/



    public void deleteRent(Rent rent) {
        rentRepository.delete(rent);
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public void saveRent(Rent rent) {
        if (rent == null) {
            System.err.println("Rent is null.");
            return;
        }

        rentRepository.save(rent);
    }



    public float CalculateRentingPrice(float RentPrice, LocalDate rentDate, LocalDate returnDate) {
        long amountOfDays = rentDate.until(returnDate, ChronoUnit.DAYS);
        return amountOfDays * RentPrice;
    }

    public long countRents() {
        return rentRepository.count();
    }

    /*public List<Rent> findAllRents(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return rentRepository.findAll();
        } else {
            return rentRepository.search(filterText);
        }
    }*/
    /*public List<Rent> findMyRents(){
        System.out.println(rentRepository.search(clientRepository.getUserId(securityConfig.getUserName())));
        return rentRepository.search(clientRepository.getUserId(securityConfig.getUserName()));
    }*/

    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    public Rent updateRent(Long id, City city, LocalDate rentDate, LocalDate returnDate, Client driver, Car car, Float price, String status) {
        Rent c = new Rent();
        c.setId(id);
        c.setCity(city);
        c.setRentDate(rentDate);
        c.setReturnDate(returnDate);
        c.setCar(car);
        c.setDriver(driver);
        c.setPrice(price);
        c.setStatus(status);
        return c;
    }

    public Rent createRent(LocalDate rentDate, LocalDate returnDate, Car car, Float price) {
        Rent r = new Rent();
        City city = car.getCity();
        Client driver = clientRepository.getUserId(securityConfig.getUserName());
        r.setCity(city);
        r.setRentDate(rentDate);
        r.setReturnDate(returnDate);
        r.setCar(car);
        r.setDriver(driver);
        r.setPrice(price);

        return rentRepository.save(r);
    }
    public List<Rent> findAll(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Rent> pagedResult = rentRepository.findAll(paging);

        return pagedResult.toList();
    }
    public List<Rent> searchRent(String parameter,int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Rent> pagedResult = rentRepository.findAll(paging);
        return rentRepository.searchRent(parameter, paging);
    }
    public List<Rent> findNotArchived(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);;
        return rentRepository.findNotArchived(paging);
    }
    public List<Rent> findArchived(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);;
        return rentRepository.findArchived(paging);
    }
    public List<Rent> findMyRents(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Rent> pagedResult = rentRepository.findAll(paging);
        Client client=clientRepository.getUserId(securityConfig.getUserName());
        Integer userId = client.getId();
        return rentRepository.search(userId, paging);
    }

    public List<Rent> searchRentArchived(String parameter,int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Rent> pagedResult = rentRepository.findAll(paging);
        return rentRepository.searchRentArchived(parameter, paging);
    }

    public Rent getRentConfirm() {
        System.out.println("serwis");

        Client client=clientRepository.getUserId(securityConfig.getUserName());
        Integer userId = client.getId();
        return rentRepository.searchForPdf(userId);
    }
}
