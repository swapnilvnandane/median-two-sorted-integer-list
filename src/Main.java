import com.sort.MedianCalculation;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(4,5);

        System.out.println("1. Median: " + MedianCalculation.calculateMedian(list1, list2));

        List<Integer> list3 = List.of(7,8,9);
        List<Integer> list4 = List.of(2,3,4);

        System.out.println("\n2. Median: " + MedianCalculation.calculateMedian(list3, list4));

        System.out.println("\n\nBoth list null.");
        MedianCalculation.calculateMedian(null, null);

        System.out.println("\n\nBoth list empty.");
        MedianCalculation.calculateMedian(List.of(), List.of());
    }
}