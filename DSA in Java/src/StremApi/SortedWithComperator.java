package StremApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedWithComperator {

    public static void main(String[] args) {
        List<Integer> list = List.of(15,2,3,9,6,4,5,6,7,8,9,10);
        Comparator<Integer> comp = (a,b)-> {
            return b - a;
        };

        Stream.of(
                new Cat(10),
                new Cat(7),
                new Cat(11),
                new Cat(9),
                new Cat(12),
                new Cat(1)

        ).sorted()
                .forEach(c-> System.out.println(c.getAge()));

        Stream.of(
                        new Dog(10),
                        new Dog(7),
                        new Dog(11),
                        new Dog(9),
                        new Dog(12),
                        new Dog(1)

                ).sorted((a,b)->b.getAge()-a.getAge())
                .forEach(c-> System.out.println(c.getAge()));


        list.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
