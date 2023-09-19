package com.example.CarRental.data.Service;

import com.example.CarRental.data.entity.Car;
import com.example.CarRental.data.entity.City;
import com.example.CarRental.data.entity.Client;
import com.example.CarRental.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<City> pagedResult = cityRepository.findAll(paging);

        return pagedResult.toList();
    }    public City saveCity(Integer id, String Nazwa, String kodPocztowy, String ulica, Integer nrLokalu) {
        City c = new City();
        c.setId_miasta(id);
        c.setNazwa(Nazwa);
        c.setKodPocztowy(kodPocztowy);
        c.setUlica(ulica);
        c.setNrLokalu(nrLokalu);

        return cityRepository.save(c);
    }

    public List<City> searchCity(String parameter,int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<City> pagedResult = cityRepository.findAll(paging);
        return cityRepository.searchCity(parameter, paging);
    }
}
