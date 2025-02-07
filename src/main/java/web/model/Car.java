package web.model;

public class Car {

    private String model;

    private String countryOfOrigin;

    private int yearOfProduction;

    public Car() {
    }

    public Car(String model, String countryOfOrigin, int yearOfProduction) {
        this.model = model;
        this.countryOfOrigin = countryOfOrigin;
        this.yearOfProduction = yearOfProduction;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
