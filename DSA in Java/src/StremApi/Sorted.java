package StremApi;

import java.util.List;

public class Sorted {

    public static void main(String[] args) {
        List<Integer> list = List.of(15,2,3,9,6,4,5,6,7,8,9,10);
        list.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }


}
