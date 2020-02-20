package main.exemple;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateJava8 {

	public static void main(String[] args) {
		Predicate<Integer> noGreaterThan5 = x -> x > 5;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> collect = list.stream().filter(noGreaterThan5).collect(Collectors.toList());

		System.out.println(collect);

		//Predicate.and()
		Predicate<Integer> noLessThan8 = x -> x < 8;

		List<Integer> collectWithPredicateAnd = list.stream().filter(noGreaterThan5.and(noLessThan8))
				.collect(Collectors.toList());

		System.out.println(collectWithPredicateAnd);
		
		//Predicate.or()
		
		List<Integer> collectWithPredicateOr = list.stream().filter(noGreaterThan5.or(noLessThan8))
				.collect(Collectors.toList());

		System.out.println(collectWithPredicateOr);
		
		//Predicate.negate() : method returns the logical negation of existing predicate.
	    Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> listS = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collectS = listS.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());

        System.out.println(collectS);
        
//In Java 11, Predicate class has new method not(). It returns a predicate that is the negation of the supplied predicate. This is accomplished by returning result of the calling predicate.negate().

	}

}
