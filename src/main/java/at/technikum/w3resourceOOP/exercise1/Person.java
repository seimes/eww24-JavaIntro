package at.technikum.w3resourceOOP.exercise1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("%s is %d years old.", this.getName(), this.getAge());
    }


    public static void main(String[] args) {
        Person person1 = new Person("John", 18);
        Person person2 = new Person("Jane", 22);

        System.out.println(person1);
        System.out.println(person2);
    }
}
