package at.technikum.exercises.voexercises.carworkshop.workers;

public class SeniorWorker extends Worker {
    public SeniorWorker(String name) {
        super(name);
    }

    @Override
    public int getHourlyRate() {
        return 50;
    }


}
