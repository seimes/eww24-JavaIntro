package at.technikum.exercises.voexercises.carworkshop;

import at.technikum.exercises.voexercises.carworkshop.workers.SeniorWorker;
import at.technikum.exercises.voexercises.carworkshop.workers.Worker;
import com.sun.scenario.animation.shared.FiniteClipEnvelope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workshop {
    private ArrayList<Worker> workers;
    private Job job;

    public Workshop() {
        this.workers = new ArrayList<Worker>();
    }

    public Workshop(Job job) {
        this.workers = new ArrayList<Worker>();
        this.job = job;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void printReport() {
        System.out.println("Workshop Report");
        System.out.println("Job: " + job.getName());
        System.out.println("Number of workers required: " + job.getMinNumberOfWorkers());
        System.out.println("Number of actual workers: " + workers.size());
        System.out.println();
        System.out.println("Hours needed: " + job.getHours());
        System.out.println();
        System.out.println("Price:");
        int workersPrice = 0;
        int numberOfSeniors = 0;
        List<Worker> seniors = workers.stream().filter(worker -> worker instanceof SeniorWorker).toList();
        System.out.println("seniors: " + seniors.size());

        for (Worker worker : workers) {
            String prefix = "Junior";
            int hourlyRate = 20;
            if(worker instanceof SeniorWorker) {
                prefix = "Senior";
                hourlyRate = 50;
                numberOfSeniors++;
            }
            int hoursPerWorker = this.job.getHours() / workers.size();
            workersPrice += hourlyRate * hoursPerWorker;
            System.out.println("- %s (%s) %d x %d".formatted(prefix, worker.getName(), hoursPerWorker, hourlyRate));
        }

        String jobPrefix = this.job instanceof CarInspection ? "Inspection" : "";
        String carAge = this.job.getBasePrice() <= 150 ? "new car" : "old car";
        int jobBasePrice = this.job.getBasePrice();
        System.out.printf("- %s (%s) %d%n", jobPrefix, carAge, jobBasePrice);
        System.out.println("-----------------------------");

        int totalPrice = jobBasePrice + workersPrice;
        System.out.println("Total: " + totalPrice);
        System.out.println();

        String status = "Status ";
        if (workers.size() >= job.getMinNumberOfWorkers() && numberOfSeniors >= 1) {
            status += "possible";
        } else {
            status += "impossible";
        }

        if (numberOfSeniors == 0) {
            status += ", at least 1 senior worker required";
        }

        System.out.println(status);
    }
}
