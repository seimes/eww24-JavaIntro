package at.technikum.w3resourceOOP.exercise13;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void isLow() {
        for (Product product: products) {
            if (product.getQuantity() <= 100) {
                System.out.println(product.getName() + " is running low on inventory. Current quantity: " + product.getQuantity());            }
        }
    }
}
