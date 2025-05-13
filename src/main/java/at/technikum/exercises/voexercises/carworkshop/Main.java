package at.technikum.exercises.voexercises.carworkshop;

import at.technikum.exercises.voexercises.carworkshop.cars.Audi;
import at.technikum.exercises.voexercises.carworkshop.workers.JuniorWorker;
import at.technikum.exercises.voexercises.carworkshop.workers.SeniorWorker;

public class Main {

    public static void main(String[] args) {
        Workshop w = new Workshop();
        w.addWorker(new SeniorWorker("Tom"));
        w.addWorker(new JuniorWorker("Tina"));

        w.setJob(new CarInspection(new Audi(2010)));

        w.printReport();
    }

    /*
    Workshop Report
    Job: Car Inspection
    Number of workers required: 2
    Number of actual workers: 2

    Hours needed: 10

    Price:
    - Senior (Tom) 5 x 50
    - Junior (Tina) 5 x 20
    - Inspection (new car) 150
    ---------
    -> 500

    Status: possible
     */
}
