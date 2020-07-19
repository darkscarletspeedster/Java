package Test5GenericsPractise;

public class GenericClass<T /*extends Employee*/,U,V> { // a type can be extended as well just like wildcard '?'
    T itemT;
    U itemU;
    V itemV;

    public GenericClass(T itemT, U itemU, V itemV) {
        this.itemT = itemT;
        this.itemU = itemU;
        this.itemV = itemV;
    }
    
    public T getItem1 () {
        return itemT;
    }

    public U getItem2 () {
        return itemU;
    }

    public V getItem3 () {
        return itemV;
    }

    public void printItems() {
        System.out.println("Item 1: " + itemT + " it's class: " + itemT.getClass());
        System.out.println("Item 2: " + itemU + " it's class: " + itemU.getClass());
        System.out.println("Item 3: " + itemV + " it's class: " + itemV.getClass());
    }
}