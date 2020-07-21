package Test6Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
    // CopyOnWriteArrayList contains synchronised ArrayList methods while working like ArrayList
    private List<Product> products = new CopyOnWriteArrayList<>();
    private List<Product> products2 = new ArrayList<>();


    public void addProducts() {
        for (int i = 0; i < 500 ; i++) {
            Product product = new Product(i, "Product_LV" + i);
            System.out.println("Adding: " + product);
            products.add(product);
        }
    }

    public void displayProducts() {
        for (int i = 0; i < 500 ; i++) {
            Product product = new Product(i, "Product_LV" + i);
            System.out.println("Adding: " + product);
            products.add(product);
        }
    }

    public void selfSyncAddProducts() {
        for (int i = 0; i < 500 ; i++) {
            synchronized (this) {
                Product product = new Product(i, "Product_SV" + i);
                System.out.println("Adding2: " + product);
                products2.add(product);
            }
        }
    }

    public void selfSyncDisplayProduct() {
        for (int i = 0; i < 500 ; i++) {
            synchronized(this){
                Product product = products2.get(i);
                System.out.println("Displaying2: " + product);
            }
        }
    }
}