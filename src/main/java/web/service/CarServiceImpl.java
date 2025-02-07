package web.service;

import web.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCount(List<Car> car, int count) {
        return car.stream().limit(count).collect(Collectors.toList());
    }
}


