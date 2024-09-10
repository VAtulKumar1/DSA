package StremApi;

import java.util.stream.Stream;

public class skipMethod {

    public static void main(String[] args) {
//        to skip first n elements of a stream
        Stream.of(1,2,3,3,45,6,6,7,7,78,8,89)
                .skip(4)
                .forEach(System.out::println);
    }
}
