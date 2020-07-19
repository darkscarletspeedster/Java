package Test5GenericsPractise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericExample {
    public static void main(String[] args) {
        GenericClass<Integer, String, Double> genericClass1 = new GenericClass<>(1, "Kshitij", 45.0);
        GenericClass<Character, Float, Boolean> genericClass2 = new GenericClass<>('K', 20.0f, true);
        GenericClass<Long, Short, Byte> genericClass3 = new GenericClass<>((long)1, (short)1, (byte)1);

        System.out.println("Object 1: ");
        genericClass1.printItems();
        System.out.println("Object 2: ");
        genericClass2.printItems();
        System.out.println("Object 3:");
        genericClass3.printItems();
        
        HashSet<String> set1 = new HashSet<>();
        set1.add("Kshitij");
        set1.add("Anuj");
        set1.add("Barry");

        HashSet<String> set2 = new HashSet<>();
        set2.add("Anuj");
        set2.add("Peter");
        set2.add("Harry");

        Set<String> result = unionSets(set1, set2);
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Employee employee = new Employee();
        Accountant accountant = new Accountant();
        // employee = accountant; //allowed as accoutant child of employee

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Accountant> accountants = new ArrayList<>();

        //employees = accountants; // not allowed as ArrayList<Accountant> no child of ArrayList<Employee>
        
        // below are allowed as list does not know the type
        ArrayList<?> list = new ArrayList<>();
        list = employees; 
        list = accountants;

        // below are allowed as list2 to told to allow max class Employee
        // and so it's children are allowed too.
        ArrayList<? extends Employee> list2 = new ArrayList<>();
        list = employees;
        list = accountants;

        //
        ArrayList<? super Employee> list3 = new ArrayList<>();
        list3 = employees;
        // list3 = accountants; // not allowed as this is opposite of extends and provides a lower bound
                             // so Employee and it's parents can only be assigned
        ArrayList<Object> objects = new ArrayList<>();
        list3 = objects; // so this can be assigned as Object is parent of everyone

        // Interface implemenants work the same way

        employees.add(employee);
        accountants.add(accountant);

        makeDoWork(employees);
        makeDoWork(accountants);

    }

    // making a generic method
    public static <E> Set<E> unionSets(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static void makeDoWork(List<? extends Employee> list) {
        for (Employee e : /*(ArrayList<Accountant>)*/ list) { // list can be type casted to it's child as wildcard extends parent class
            e.doWork();
        }
    }
}