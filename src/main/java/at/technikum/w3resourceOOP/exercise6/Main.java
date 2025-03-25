package at.technikum.w3resourceOOP.exercise6;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sam", "Manager", 40000);
        Employee emp2 = new Employee("Nick", "Software Engineer", 60000);

        emp1.printEmployeeInfo();
        System.out.println();
        emp2.printEmployeeInfo();

        emp1.raiseSalary(8);
        emp2.raiseSalary(12);
        System.out.println();

        emp1.printEmployeeInfo();
        System.out.println();
        emp2.printEmployeeInfo();
    }
}
