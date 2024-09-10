package StremApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedWithComperator {

    public static void main(String[] args) {
        List<Integer> list = List.of(15,2,3,9,6,4,5,6,7,8,9,10);
        Comparator<Integer> comp = (a,b)-> {
            return b - a;
        };
        list.stream()
                .distinct()
                .sorted((a,b)->b-a)
                .forEach(System.out::println);
    }
}
