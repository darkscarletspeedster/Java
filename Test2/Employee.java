package Test2;

import java.lang.Math;

public class Employee implements Comparable<Employee> {
    private String name;
    private String employeeCode;
    private double experience;
    private int totalCarsSold = 0;
    private double incentive = 0;
    public boolean isBusy = false;

    public Employee(String name, String employeeCode, int experience) {
        this.name = name;
        this.employeeCode = employeeCode;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public int getExperience() {
        return (int) Math.floor(experience);
    }

    @Override
    public int compareTo(Employee o) {
        if (this.experience > o.experience)
            return 1;
        if (this.experience < o.experience)
            return -1;
        else
            return 0;
    }

    public void updateEmployee(int carsSold) {
        totalCarsSold += carsSold;
        incentive = totalCarsSold*10000;
        experience = experience + (carsSold/10);
    }
}