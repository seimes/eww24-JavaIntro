package at.technikum.w3resourceOOP.exercise8;

import java.util.Objects;

public class TrafficLight {
    private String color;
    private int duration;

    public TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isRed() {
        return this.color.equals("red") || this.color.equals("Red");
    }

    public boolean isGreen() {
        return this.color.equals("green") || this.color.equals("Green");
    }
}
