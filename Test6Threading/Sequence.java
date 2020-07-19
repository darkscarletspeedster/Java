package Test6Threading;

public class Sequence {
    private int value = 0;

    public int getNext() {
        // this block ensures that the code within it is executed and only then other thread can have control over it
        // It basically locks current thread for execution of this block
        synchronized(this) {
            System.out.println("For Value: " + value);
            value = value + 1;
            return value;
        }
    }

    public void resetValue() {
        value = 0;
    }

    // this method basically makes the whole method synchrised, it is similar to above method just
    // instead of a specific random block that block can be a method in itself
    public synchronized int getSynchronisedNext() {
        value++;
        return value;
    }
}