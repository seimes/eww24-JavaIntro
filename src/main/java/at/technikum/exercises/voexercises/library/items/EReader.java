package at.technikum.exercises.voexercises.library.items;

public class EReader extends Item implements IRentable {
    private String name;
    private String manufacturer;

    public EReader(String name, String manufacturer, boolean available) {
        super(available);
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void print() {
        System.out.printf("EReader %s %s%n", this.name, this.manufacturer);
    }

    @Override
    public void rent() {

    }
}
