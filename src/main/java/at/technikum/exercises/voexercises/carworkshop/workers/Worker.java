package at.technikum.exercises.voexercises.carworkshop.workers;

public abstract class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getHourlyRate();
 }
