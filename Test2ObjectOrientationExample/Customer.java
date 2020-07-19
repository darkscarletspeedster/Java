package Test2ObjectOrientationExample;

public class Customer {
    private String name;
    private double inHandCash;
    private String city;
    private int decisionTime;

    public Customer (String name, double inHandCash, String city, int decisionTime) {
        this.name = name;
        this.inHandCash = inHandCash;
        this.city = city;
        this.decisionTime = decisionTime;
    }

    public String getName() {
        return name;
    }

    public double getInHandCash() {
        return inHandCash;
    }

    public String getCity() {
        return city;
    }

    public int getDecisionTime () {
        return decisionTime;
    }

    public void decrementDecisionTime () {
        decisionTime--;
    }

    public void updateInHandCash(double moneySpent) {
        inHandCash -= moneySpent;
    }
}