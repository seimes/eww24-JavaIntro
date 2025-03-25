package at.technikum.w3resourceOOP.exercise6;

public class Employee {
    private String name;
    private String jobTitle;
    private double salary;

    public Employee(String name, String jobTitle, double salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void raiseSalary(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    public String toString() {
        return String.format("Name: %s\nJob Title: %s\nSalary: €%.2f", this.getName(), this.getJobTitle(), this.getSalary());
    }

    public void printEmployeeInfo() {
        System.out.println(this);
    }
}
