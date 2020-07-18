package Test4;

// provides example for hashcode and equal function override for a custom object
public class HashCodeAndEqualOverride {
    String name;
    public static void main(String[] args) {
        String a = "kshitij";
        String b = "kshitij";
        System.out.println(a == b); //true
    }
}

class Test {
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
}