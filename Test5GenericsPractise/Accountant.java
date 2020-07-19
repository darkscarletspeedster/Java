package Test5GenericsPractise;

public class Accountant extends Employee{

    // override tag is given just to be self explainatory that which method overridding
    // and which method belongs to this class
    @Override
    public void doWork() {
        System.out.println("Accountant is Working");
    }
}