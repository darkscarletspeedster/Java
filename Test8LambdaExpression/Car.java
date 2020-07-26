package Test8LambdaExpression;

public class Car {
    private String company;
    private String model;
    private String color;
    private int price;

    public Car(String company, String model, String color, int price) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [color=" + color + ", company=" + company + ", model=" + model + ", price=" + price + "]";
    }
}