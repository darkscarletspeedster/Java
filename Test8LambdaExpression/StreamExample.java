package Test8LambdaExpression;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        // Integer Stream
        IntStream.range(0, 11)
            .skip(5) // skips 5 elements
            .forEach((x) -> System.out.println(x));

        // Inetger sum with Stream
        int val = IntStream.range(1, 10)
            .sum();
        System.out.println("Sum: " + val);

        // Sorting using stream and using find first
        Stream.of("Hello", "Bottle", "Africa")
            .sorted()
            .findFirst()
            .ifPresent((x) -> System.out.println(x)); // handles null pointer exception

        // Stream with array, sort and filter
        String[] items = {"car", "computer", "toothpaste", "telephone", "box"};
        Stream.of(items)
            .filter((x) -> x.startsWith("t")) // filters elements from array starting with 't'
            .sorted()
            .forEach((x) -> System.out.println(x)); 

        // Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
            .map(x -> x*x)
            .average()
            .ifPresent(n -> System.out.println(n));

        // Streams with Lists
        List<String> listOfItems = Arrays.asList("Car", "computer", "Toothpaste", "telephone", "box");
        listOfItems.stream()
            .map((x) -> x.toLowerCase())
            .filter(s -> s.startsWith("c") || s.startsWith("t"))
            .sorted()
            .forEach(x -> System.out.println(x));

        // Stream and files
        Stream<String> lines = Files.lines(Paths.get("StreamFile.txt")); // reads per line and takes it as a single
        lines.filter(l -> l.length() > 4)
            // .sorted()
            .forEach(x -> System.out.println(x + " "));
        lines.close(); // stream must be closed every time dealing with files

        // list as Stream
        List<String> words = Files.lines(Paths.get("StreamFile.txt"))
            .filter(x -> x.contains("ra"))
            .collect(Collectors.toList());
        words.forEach(x -> System.out.println(x));

        // Counting number of words per line
        Stream<String> lines2 = Files.lines(Paths.get("myFile.txt"));
        int count = (int) lines2.map(x -> x.split(" ")) // creates a Stream<Object[]>
                        .filter(x -> x.length > 3) // filtering every array having lenght greater than 3
                        .count(); // counting how many arrays left
        System.out.println(count);
        lines2.close();

    }
}