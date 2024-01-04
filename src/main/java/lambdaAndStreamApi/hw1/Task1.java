package lambdaAndStreamApi.hw1;

import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> arr = List.of(5,2,1,5,6,7,2,1);
        AtomicInteger counter = new AtomicInteger(0);
        OptionalDouble evenNumMean = arr.stream()
                .filter(num -> num % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println("Average of the elements of the stream " +
                (evenNumMean.isPresent() ? evenNumMean.getAsDouble() : "nothing"));
    }
}
