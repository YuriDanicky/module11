package module11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task11Test {
    public static void main(String[] args) throws FileNotFoundException {

        //Task1Test
        //Make List of names

        System.out.println("    Task1Test:");

        Scanner scanner = new Scanner(new FileInputStream("src/main/java/module11/namelist.txt"));
        List<String> nameList = new ArrayList<>();
        while (scanner.hasNext()) {
            nameList.add(scanner.nextLine());
        }

        System.out.println("nameList = " + nameList);

        // Task1Test solution

        System.out.println("oddNames(nameList) = " + oddNames(nameList) + "\n");

        // Task2Test
        // Make List of words

        System.out.println("    Task2Test:");

        Scanner scanner1 = new Scanner(new FileInputStream("src/main/java/module11/text.txt"));
        List<String> words = new LinkedList<>();
        while (scanner1.hasNext()) {
            words.add(scanner1.next());
        }
        System.out.println("words = " + words);

        //Task2Test solution

        System.out.println("toUpperReversSort(words) = " + toUpperReversSort(words) + "\n");

        //Task3

        System.out.println("    Task3:");

        String[] array = {"1,2,0", "4,5"};
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("sortInt(array) = " + sortInt(array) + "\n");

        //Task4

        System.out.println("    Task4:");

        MyRandom random = new MyRandom(25214903917L, 11L, (long) Math.pow(2, 48));
        Stream longStream = Stream.iterate(0L, (seed) -> (random.seed(seed).next()));
        longStream.limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Task5

        System.out.println("    Task5:");

        //generate some objects

        Stream<Task5Object> stream10 = Stream.of(
                new Task5Object(1, "qqqqq"),
                new Task5Object(2, "wwwww"),
                new Task5Object(3, "eeeee"),
                new Task5Object(4, "rrrrr")
        );
        Stream<Task5Object> stream20 = Stream.of(
                new Task5Object(10, "qqq"),
                new Task5Object(20, "www"),
                new Task5Object(30, "eee"),
                new Task5Object(40, "rrr"),
                new Task5Object(50, "ttt")
        );

        zip(stream10, stream20)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    //Implements methods:

    public static String oddNames(List<String> nameList) {
        return nameList.stream()
                .filter(name -> nameList.indexOf(name) % 2 == 0)
                .collect(Collectors.joining(", "));
    }

    public static List<String> toUpperReversSort(List<String> words) {
        return words.stream()
                .map(s -> s.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> sortInt(String[] array) {
        return Arrays.stream(array)
                .map(elem -> Arrays.asList(elem.split(",")))
                .flatMap(Collection::stream)
                .sorted()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> iterator = second.iterator();

        return first.
                flatMap(a -> iterator.hasNext() ? (Stream.concat(Stream.of(a), Stream.of(
                        (iterator.next())))) : null);
    }
}
