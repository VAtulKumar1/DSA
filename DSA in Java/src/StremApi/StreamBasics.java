package StremApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,5,7,10,12,27,18);
//        list.stream()
//                .filter(x -> x%2 == 0)
//                .forEach(System.out::println);

//        Stream s1 = Stream.empty();
//        s1.forEach(System.out::println);

//        Stream<Integer> s2 = Stream.of(1,2,3,5,6,10,45);
//        s2.forEach(System.out::println);
        Supplier<Integer> sup = () -> new Random().nextInt();
        Stream<Integer> s3 = Stream.generate(sup);
        s3.
                limit(10).
                forEach(System.out::println);
    }

}
