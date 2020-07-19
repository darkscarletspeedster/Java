package Test4CollectionsPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// provides example for hashcode and equal function override for a custom object
public class HashCodeAndEqualOverride {
    String name;
    public static void main(String[] args) {
        String a = "kshitij";
        String b = "kshitij";
        System.out.println(a == b); //true

        ArrayList<Test> tests = new ArrayList<>();
        Collections.sort(tests); // test can be sorted as it implements comparable interface

        // Tree sets are useful storing data in sorted order according to keys
        // TreeMaps work in similar fashion for hashmap keys
        // For complex objects in TreeSet/TreeMap the object class should implement complarable interface
        TreeSet<Test> sets = new TreeSet<>();
        Test test = new Test();
        test.name = "Kshitij";
        sets.add(test);
        test = new Test();
        test.name = "Anuj";
        sets.add(test);
        for (Test value : sets) {
            System.out.println(value);
        }


        // LinkedHashMap and LinkedHashSet are used to use hashmaps/hashsets to store data in the order of their insertion
        LinkedHashMap<String, Test> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(test.name, test);
        test = new Test();
        test.name = "kshtitij";
        linkedHashMap.put(test.name, test);
        for (Map.Entry<String, Test> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

class Test implements Comparable<Test> {
    String name;
    boolean check;
    float frac;
    char c;
    double bigFrac;
    int num;
    long bigNum;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(bigFrac);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (bigNum ^ (bigNum >>> 32));
        result = prime * result + c;
        result = prime * result + (check ? 1231 : 1237);
        result = prime * result + Float.floatToIntBits(frac);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + num;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Test other = (Test) obj;
        if (Double.doubleToLongBits(bigFrac) != Double.doubleToLongBits(other.bigFrac))
            return false;
        if (bigNum != other.bigNum)
            return false;
        if (c != other.c)
            return false;
        if (check != other.check)
            return false;
        if (Float.floatToIntBits(frac) != Float.floatToIntBits(other.frac))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (num != other.num)
            return false;
        return true;
    }

    @Override
    public int compareTo(Test o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        // is used to get a better printed view of objects rather than default view of their hashcodes
        return "Test [bigFrac=" + bigFrac + ", bigNum=" + bigNum + ", c=" + c + ", check=" + check + ", frac=" + frac
                + ", name=" + name + ", num=" + num + "]";
    }
}