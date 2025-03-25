package at.technikum.w3resourceOOP.exercise2;

public class Dog {
    private String name;
    private String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Max", "Cocker Spaniel");
        Dog dog2 = new Dog("Simba", "Dachshund");

        dog1.setBreed("Golden Retriever");
        dog2.setBreed("Frenchie");
        dog1.setName("Maxi");
        dog2.setName("Sumi");

        System.out.println("name: " + dog1.getName() + ", breed: " + dog1.getBreed());
        System.out.println("name: " + dog2.getName() + ", breed: " + dog2.getBreed());
    }
}
