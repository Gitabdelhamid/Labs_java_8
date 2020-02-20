package main.exemple;

import java.util.function.BiPredicate;

public class BiPredicateJava8 {
	
	public static void main(String[] args) {
		
		
		BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("AAAART", 6);
        System.out.println(result);  // true

        boolean result2 = filter.test("aaa", 10);
        System.out.println(result2); // false
	}

}
