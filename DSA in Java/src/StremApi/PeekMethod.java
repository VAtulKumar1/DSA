package StremApi;

import java.util.stream.Stream;

public class PeekMethod {

    public static void main(String[] args) {
        // to peek into stream in the middle of the operations
        Stream.of(12,2,3,3,4,45,54,5,5)
                .peek(n-> System.out.println(n))
                .distinct()
                .forEach(System.out::println);
    }
}
