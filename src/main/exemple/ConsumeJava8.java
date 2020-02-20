package main.exemple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumeJava8 {

	public static void main(String[] args) {
//		In Java 8, Consumer is a functional interface; it takes an argument and returns nothing.
//
//		@FunctionalInterface
//		public interface Consumer<T> {
//		  void accept(T t);
//		}
		
		//EXEMPLE 1
		Consumer<String> print = x -> System.out.println(x);
        print.accept("java");   // java
        
        //EXEMPLE 2
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
        forEach(list, consumer);

        // or call this directly
        forEach(list, (Integer x) -> System.out.println(x));        

	}
    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

}
