package main.exemple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateJava8 {

	public static void main(String[] args) {

		BiPredicate<String, Integer> filter = (x, y) -> {
			return x.length() == y;
		};

		boolean result = filter.test("AAAART", 6);
		System.out.println(result); // true

		boolean result2 = filter.test("aaa", 10);
		System.out.println(result2); // false

		//This example uses BiPredicate to filter bad domains by the domain name or threat score
		List<Domain> domains = Arrays.asList(new Domain("google.com", 1), new Domain("i-am-spammer.com", 10),
				new Domain("facbok.com", 0), new Domain("microsoft.com", 2));

		BiPredicate<String, Integer> bi = (domain, score) -> {
			return (domain.equalsIgnoreCase("google.com") || score == 0);
		};

		// if google or score == 0
		List<Domain> result_ = filterBadDomain(domains, bi);
		System.out.println(result_); // google.com, facbok.com

		// if score == 0
		List<Domain> result2_ = filterBadDomain(domains, (domain, score) -> score == 0);
		System.out.println(result2_); // facbok.com, microsoft.com

		// if start with i or score > 5
		List<Domain> result3_ = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
		System.out.println(result3_); // i-am-spammer.com

		// chaining with or
		List<Domain> result4 = filterBadDomain(domains, bi.or((domain, x) -> domain.equalsIgnoreCase("microsoft.com")));
		System.out.println(result4); // google.com, facbok.com, microsoft.com

	}

	public static <T extends Domain> List<T> filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate) {
		return list.stream().filter(x -> biPredicate.test(x.getName(), x.getScore())).collect(Collectors.toList());

	}
}

class Domain {

	String name;
	Integer score;

	public Domain(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	// getters , setters , toString

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
