package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		
		//1. from Collections
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list.stream().filter(x -> x%2 ==0).toList());
		
		//2. from Arrays
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.stream(arr).map(x -> x*x).boxed().toList());
		
		//3. using Stream.of
		System.out.println(Stream.of(1,2,3,4,5).map(x -> x*x).collect(Collectors.toList()));
		
		// 4. Infinite streams
        System.out.println(Stream.generate(() -> 1).limit(10).toList());
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).toList());
        
        System.out.println(Stream.iterate(14,x -> x%7 ==0,x -> x+14).limit(10).toList());
		
		
		
	}
}
