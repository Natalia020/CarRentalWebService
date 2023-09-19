package com.example.CarRental.data.repository;

import com.example.CarRental.data.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    @Query("select a.car.id from Rent a where a.rentDate between " +
            "?1 and ?2 or a.returnDate between ?1 and ?2")
    List<Long> getAllCarsBookedBetween(LocalDate rentDate, LocalDate returnDate);
    public Page<Car> findAllByidNotIn(List<Long> id, Pageable pageable);
    @Query(value = "select c from Car c where c.model like %:parameter%")
    List<Car> searchByModel(@Param("parameter") String model, Pageable pageable);
    @Query(value = "select c from Car c where c.registrationNumber like %:parameter%")
    List<Car> searchNR(@Param("parameter") String registrationNumber, Pageable pageable);
    @Query(value = "select c from Car c where c.paliwo like %:parameter%")
    List<Car> searchPaliwo(@Param("parameter") String fuel, Pageable pageable);
    @Query(value = "select c from Car c where c.skrzBieg like %:parameter%")
    List<Car> searchSkrzBieg(@Param("parameter") String gearBox, Pageable pageable);
    @Query(value = "select c from Car c where c.lMiejsc = ?1")
    List<Car> searchLMiejsc(@Param("parameter") Integer seats, Pageable pageable);
    @Query(value = "select c from Car c where c.price between ?1 and ?2")
    List<Car> searchPrice(@Param("parameter") String min,String max, Pageable pageable);
    @Query(value = "select c from Car c where c.pojSilnika between ?1 and ?2")
    List<Car> searchPoj(@Param("parameter") Float min,Float max, Pageable pageable);
    @Query(value = "select c from Car c where c.mileage between ?1 and ?2")
    List<Car> searchMileage(@Param("parameter") Integer min, Integer max, Pageable pageable);
    @Query(value = "select c from Car c where c.model like %:parameter% or " +
            "c.registrationNumber like %:parameter%")
    List<Car> searchByModelOrRegistrationNumber(@Param("parameter") String parameter);
}
