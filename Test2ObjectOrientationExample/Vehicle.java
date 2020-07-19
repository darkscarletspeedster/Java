package Test2ObjectOrientationExample;

import java.util.*;

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

    public int sellVehicle(Customer customer, Employee employee) {
        System.out.println("Enter quantity (Available-" + this.count + ") each pricing at ₹" + price + " : ");
        Scanner sc = new Scanner(System.in);
        int value = 0;
        while (true) {
            value = sc.nextInt();
            if (value <= count) {
                while (true) {
                    if (customer.getInHandCash() < value * price) {
                        System.out.println("Sorry you can't buy these many cars, select less cars: ");
                        value = sc.nextInt();
                    } else
                        break;
                }
                break;
            } else {
                System.out.println("Please Enter Valid number!!!");
            }
        }

        customer.updateInHandCash(value*price);
        employee.updateEmployee(value);
        count -= value;
        sc.close();
        return value;
    }

}