public class Home {
    public static void main(final String[] args) {
        String str = "We have a large inventory of things in our warehouse falling in"
        + "the category:apparel and the slightly "
        + "more in demand category:makeup along with the category:furniture and ....";

        printCategories(str);
    }

    public static void printCategories(String s) {
        int i = 0;
        while (true) {
            int indexCat = s.indexOf("category:", i);
            if (indexCat == -1)
                break;

            int endIndex = s.indexOf(" ", indexCat);
            System.out.println(s.substring(indexCat + 9, endIndex));
            i = endIndex + 1;
        }
    }
}