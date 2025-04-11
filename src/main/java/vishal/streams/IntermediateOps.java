package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Vishal", "Akshit", "Rohan", "Vivek");
		
		System.out.println(list.stream().anyMatch(x -> x.startsWith("A")));
		System.out.println(list.stream().allMatch(x -> x.length() >= 5));
		System.out.println(list.stream().dropWhile(X -> X.length() > 5).toList());
		System.out.println(list.stream().reduce((a,b) -> a+"_"+b).get());
		
		System.out.println(list.stream().map(x -> new StringBuilder(x).reverse()).collect(Collectors.joining(" ")));
		System.out.println(list.stream().distinct().toList());
		System.out.println(list.stream().filter(x -> x.endsWith("l")).toList());
		
		System.out.println(list.stream().peek(x ->  System.out.println("before: "+x))
										.map(x -> x.toUpperCase())
										.peek(x -> System.out.println("After:" + x))
										.toList());
		
		
		System.out.println(list.stream().sorted().toList());
		System.out.println(list.stream().sorted((a,b) -> b.compareTo(a)).toList());
		
		Stream.iterate(1, x -> x+1).skip(10).limit(20).peek(x -> System.out.println(x)).count();
		
		List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        
		System.out.println(listOfLists.stream().flatMap(x -> x.stream())
							.map(x -> x.toUpperCase())
							.toList());		
		
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
        					.map(words -> new StringBuilder(words).reverse())
        					.collect(Collectors.joining(" ")));
        
        
							
		
	}
}
