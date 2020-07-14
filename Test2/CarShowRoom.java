package Test2;

import java.util.*;

public class CarShowRoom {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        Stack<Customer> customers = new Stack<>();
        HashSet<String> deliverableCity = new HashSet<>();
        double minCarValue = 0;
        HashMap<String, Integer> busyMap = new HashMap<>();

        vehicles.add(new Vehicle("Tesla", "T1", 100000000, 5));
        vehicles.add(new Vehicle("Ford", "Fv2", 10000000, 10));
        vehicles.add(new Vehicle("Tesla", "L2", 5000000, 20));
        vehicles.add(new Vehicle("Ford", "A1", 20000000, 10));
        minCarValue = vehicles.get(2).getPrice();

        employees.add(new Employee("Raj", "E1", 1));
        employees.add(new Employee("Ron", "E2", 0));

        deliverableCity.add("Pune");
        deliverableCity.add("Mumbai");
        deliverableCity.add("Delhi");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Add Customer?Yes(Y/y) or No(N/n): ");
            char c = sc.next().charAt(0);
            if (c == 'Y' || c == 'y') {
                Customer customer = null;
                System.out.println("Enter customer Name: ");
                String name = sc.next();
                System.out.println("Enter customer In Hand Cash: ");
                double inHandCash = sc.nextDouble();
                if (inHandCash >= minCarValue) {
                    System.out.println("Enter customer City: ");
                    String city = sc.next();
                    if (deliverableCity.contains(city)) {
                        System.out.println("Enter customer time: ");
                        int decisionTime = sc.nextInt();
                        customer = new Customer(name, inHandCash, city, decisionTime);
                    } else {
                        System.out.println("Can't deliver to this address, add this address?Yes(Y/y) or No(N/n): ");
                        c = sc.next().charAt(0);
                        if (c == 'Y' || c == 'y') {
                            System.out.println("ok city added customer addition can proceed....");
                            deliverableCity.add(city);
                            System.out.println("Enter customer time: ");
                            int decisionTime = sc.nextInt();
                            customer = new Customer(name, inHandCash, city, decisionTime);
                        } else {
                            System.out.println("Sorry customer was sent back.");
                        }
                    }
                } else {
                    System.out.println("Sorry not safe amount so could not create Customer.");
                }

                if (customer != null) {
                    if (busyMap.size() != employees.size()) {
                        Employee employee = getEmployee(employees);
                        busyMap.put(employee.getEmployeeCode(), customer.getDecisionTime());
                        System.out.println("Employee assigned to Customer.");
                    } else {
                        System.out.println("Customer has to wait as all employees are busy!!!");
                        System.out.println("Should Add new Employee?Yes(Y/y) or No(N/n): ");
                        c = sc.next().charAt(0);
                        if (c == 'Y' || c == 'y') {
                            System.out.println("Enter employee Name: ");
                            String employeeName = sc.next();
                            System.out.println("Enter employee Code: ");
                            String employeeCode = sc.next();
                            System.out.println("Enter employee Experience: ");
                            int experience = sc.nextInt();
                            employees.add(new Employee(employeeName, employeeCode, experience));
                            Employee employee = getEmployee(employees);
                            busyMap.put(employee.getEmployeeCode(), customer.getDecisionTime());
                            System.out.println("Employee assigned to Customer.");
                        } else {
                            System.out.println("Ok. Customer waits.");
                        }
                    }
                }

                for (Map.Entry<String, Integer> entry : busyMap.entrySet()) {
                    busyMap.put(entry.getKey(), entry.getValue() - 1);
                    int value = busyMap.get(entry.getKey());
                    if (value == 0) {
                        System.out.println("Select Model: ");
                        for (int i = 0; i < vehicles.size(); i++) {
                            Vehicle vehicle = vehicles.get(i);
                            if (vehicle.getCount() != 0)
                                System.out
                                        .println((i + 1) + ". " + vehicle.getCompanyName() + " " + vehicle.getModel());
                        }
                        Vehicle vehicle = null;
                        while (true) {
                            int model = sc.nextInt();
                            if (model <= vehicles.size() && model > 0) {
                                vehicle = vehicles.get(model - 1);
                                break;
                            } else {
                                System.out.println("No such model available");
                            }
                        }
                        vehicle.sellVehicle(customer, employee);
                    }
                }
            }
        }
        sc.close();
    }

    private static Employee getEmployee(ArrayList<Employee> employees) {
        Collections.sort(employees);
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (!employee.isBusy) {
                employee.isBusy = true;
                return employee;
            }
        }
        return null;
    }
}