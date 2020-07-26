package Test8LambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // for lambda to work, it should be a fucntional interafce
        // and a fucntion interface can be a interface with only one function
        // also Interface type check should be present
        // even if two interfaces are functional interface they cannot be mapped to each other
        // if none of them extends the other
        LambdaInterface lambdaInterface = (name) -> System.out.println(name);

        // with curly brackets
        LambdaInterface lambdaInterface2 = (name) -> {
            System.out.println("Hello " + name);
            System.out.println("Bye!!!!");
        };

        // return interface
        // for single line no return statement required
        Calculate cal = (a, b) -> a + b;

        //using generic interface
        GenericInterface<Integer> genericInterface = (n) -> {
            int result = 1;
            for (int i = n; i >= 1; i--) {
                result *= i;
            }
            return result;
        };
        GenericInterface<String> genericInterface2 = (str) -> {
            String s = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                s += str.charAt(i);
            }
            return s;
        };
    
        lambdaInterface.interfaceFunction("Kshitij");
        lambdaInterface2.interfaceFunction("Mark");
        System.out.println("Sum of 5 and 6 is: " + cal.sum(5, 6));
        System.out.println("Factorial of 10 is: " + genericInterface.work(10));
        System.out.println("Reverse of somestring is: " + genericInterface2.work("somestring"));

        // making a where clause function and making real use of fucntional interface
        List<Car> cars = Arrays.asList(new Car("Tesla", "T1", "Blue", 10000)
            ,new Car("Maruti", "M1", "Red", 5000)
            ,new Car("Ford", "F1", "White", 7000)
            ,new Car("Tata", "T1", "Black", 6000)
            ,new Car("Honda", "H1", "Yellow", 6000)
            ,new Car("Lamborgini", "L1", "Blue", 15000)
            ,new Car("Ferrari", "F1", "Red", 15000));
            
        // Functional Interface can work with paramrter brackets as well
        // at least for single parameter, haven't tried for multiple parameter    
        List<Car> filteredCars = Where(cars, x -> x.getColor().equals("Red") || x.getPrice() >= 10000);
        System.out.println("Filtered Cars: ");
        for (int i = 0; i < filteredCars.size(); i++) {
            System.out.println(filteredCars.get(i));
        }
    }

    private static <O> List<O> Where(List<O> items, WhereClause<O> whereClause) {
        List<O> filteredList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            O item = items.get(i);
            if (whereClause.Condition(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }
}

@FunctionalInterface
interface Calculate {
    int sum(int arg1, int arg2);
}

@FunctionalInterface
interface GenericInterface<T> {
    T work (T t);
}

@FunctionalInterface
interface WhereClause<T> {
    boolean Condition(T item);
}