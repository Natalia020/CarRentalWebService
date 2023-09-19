package com.example.CarRental.data.Service;


import com.example.CarRental.data.entity.Car;

import java.util.List;

public interface PageService {

    List<Car> findPaginated(int pageNo, int pageSize);
}
