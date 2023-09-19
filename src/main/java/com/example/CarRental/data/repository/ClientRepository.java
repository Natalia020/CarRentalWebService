package com.example.CarRental.data.repository;

import com.example.CarRental.data.entity.Car;
import com.example.CarRental.data.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

    @Repository
    public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

        @Query("select c from Client c " +
                "where  lower(c.Id) like lower(concat('%', :searchTerm, '%') ) " +
                "or lower(c.LastName) like lower(concat('%', :searchTerm, '%') ) ")
        List<Client> search(@Param("searchTerm") String searchTerm);

        @Query("select c from Client c where c.Email = ?1 ")
        public <Client> Client getUserId(String searchTerm);

        @Query(value = "select * from Client c where c.email like %:parameter% or c.last_name like %:parameter% or c.name like %:parameter% or c.role like %:parameter%", nativeQuery = true)
        List<Client> searchClient(@Param("parameter") String parameter, Pageable pageable);

    }
