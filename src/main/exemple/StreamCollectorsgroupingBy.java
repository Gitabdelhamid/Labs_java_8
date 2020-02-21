package main.exemple;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

public class StreamCollectorsgroupingBy {

	public static void main(String[] args) {	
	//3 apple, 2 banana, others 1
    List<String> items =
            Arrays.asList("apple", "apple", "banana",
                    "apple", "orange", "banana", "papaya");

    //===============================Exemple 1 :   Group By, Count and Sort==========================================================
    
    Map<String, Long> result =
            items.stream().collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
            );

    System.out.println(result);//{papaya=1, orange=1, banana=2, apple=3}
    
    //===============================Exemple 2 :   Sort a map and add to finalMap==========================================================
    Map<String, Long> result_ =
            items.stream().collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
            );

    Map<String, Long> finalMap = new LinkedHashMap<>();

    //Sort a map and add to finalMap
    result_.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue()
                    .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

    System.out.println(finalMap);


}
}

