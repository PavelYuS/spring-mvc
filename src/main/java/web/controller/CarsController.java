package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int a, ModelMap model) {

        CarService cs = new CarServiceImpl();
        List<Car> listCars = new ArrayList<>();

        listCars.add(new Car("Aristo", "Japan", 2010));
        listCars.add(new Car("GTR","Japan",2011));
        listCars.add(new Car("Solaris", "South Korea", 2012));
        listCars.add(new Car("Mondeo", "USA", 2014));
        listCars.add(new Car("M5", "Germany", 2022));

        model.addAttribute("cars", cs.getCount(listCars, a));

        return "cars";
    }
}
