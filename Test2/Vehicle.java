package Test2;

public class Vehicle {
    private String companyName;
    private String model;
    private double price;
    private int count;

    public Vehicle(String companyName, String model, double price, int count) {
        this.companyName = companyName;
        this.model = model;
        this.price = price;
        this.count = count;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void sellVehicle(Customer customer, Employee employee) {

    }

}