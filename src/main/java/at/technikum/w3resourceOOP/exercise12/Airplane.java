package at.technikum.w3resourceOOP.exercise12;

import java.time.LocalTime;

public class Airplane {
    private String flightNumber;
    private String destination;
    private LocalTime departureTime;
    private int delay;

    public Airplane(String flightNumber, String destination, LocalTime departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.delay = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getDelay() {
        return this.delay;
    }

    public void setDelay(int delayInMinutes) {
        this.delay = delayInMinutes;
        this.departureTime = this.departureTime.plusMinutes(this.delay);
    }

    public void checkStatus() {
        if (this.delay == 0) {
            System.out.println("Flight " + this.flightNumber + " is on time.");
        } else {
            System.out.println("Flight " + this.flightNumber + " is delayed by " + this.delay + " minutes.");
        }
    }
}
