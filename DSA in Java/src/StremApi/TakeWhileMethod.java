package StremApi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeWhileMethod {

    public static void main(String[] args) {
        // take all the element which respect the predicate
        List<Integer> take = Stream.of(1,2,3,4,5,67,100,140,190)
                .takeWhile(n -> n<=100)
                .toList();

        List<Integer> drop = Stream.of(1,2,3,4,5,67,100,140,190)
                .dropWhile(n -> n<=100)
                .toList();

        System.out.println(take);
        System.out.println(drop);



    }
}
