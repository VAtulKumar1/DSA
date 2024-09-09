package StremApi;

import java.util.*;
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
//        Supplier<Integer> sup = () -> new Random().nextInt();
//        Stream<Integer> s3 = Stream.generate(sup);
//        s3.
//                limit(10).
//                forEach(System.out::println);

        /*map intermediate operation on streams*/

//
//        List<String>  names = List.of("Atul","Alok","Niaranjan");
//        var response =names.stream()
//                .mapToInt(String::length)
//                .sum();
//        System.out.println(response);


//        List<String>  names = List.of("Atul","Alok","Niaranjan");
//        names.stream()
//                .map(s-> new StringBuilder(s).reverse())
//                .forEach(System.out::println);

        List<List<Integer>> list1 = List.of(
                List.of(1,2,3,4,5),
                List.of(10,2,3,20)
        );

        var res = list1.stream()
                .flatMap(Collection::stream)
                .reduce(0, Integer::sum);
        System.out.println(res);

        String digits = "0123456789";
        List<String> list2 = List.of("hjfdfd12323dgh","jdgd7363452gkdg","dkhdg7823vdhwgdd7ege37teh3");
        var res1 = list2.stream()
                .flatMap(s-> Arrays.stream(s.split("")))
                .filter(digits::contains)
                .count();

        System.out.println(res1);



    }

}
