package main.exemple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertPrimitiveArrayToListJava8 {
    public static void main(String[] args) {

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // IntStream.of or Arrays.stream, same output
        //List<Integer> list = IntStream.of(number).boxed().collect(Collectors.toList());
		
        List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);

    }
}
