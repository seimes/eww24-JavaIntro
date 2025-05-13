package at.technikum.exercises.voexercises.carworkshop.workers;

public class JuniorWorker extends Worker {
    public JuniorWorker(String name) {
        super(name);
    }

    @Override
    public int getHourlyRate() {
        return 20;
    }
}
