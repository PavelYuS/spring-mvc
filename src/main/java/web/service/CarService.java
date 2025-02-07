package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCount(List<Car> car, int count);
}



