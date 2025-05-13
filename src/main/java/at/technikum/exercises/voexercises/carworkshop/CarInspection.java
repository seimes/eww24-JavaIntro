package at.technikum.exercises.voexercises.carworkshop;

import at.technikum.exercises.voexercises.carworkshop.cars.Car;

public class CarInspection implements Job {
    private Car car;

    public CarInspection(Car car) {
        this.car = car;
    }

    @Override
    public int getMinNumberOfWorkers() {
        return 2;
    }

    @Override
    public int getBasePrice() {
        return this.car.getYear() < 2000 ? 200 : 150;
    }

    @Override
    public int getHours() {
        return 10;
    }

    @Override
    public String getName() {
        return "Car Inspection";
    }
}
