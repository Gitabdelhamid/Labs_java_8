package main.exemple;

import java.util.function.BiConsumer;

public class BiConsumerJava8 {
	
	
	// *In Java 8, BiConsumer is a functional interface; it takes two arguments and returns nothing.
//	@FunctionalInterface
//	public interface BiConsumer<T, U> {
//	  void accept(T t, U u);
//	}
	
	 public static void main(String[] args) {

	      BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
	      addTwo.accept(1, 2);    // 3

	    }

}
