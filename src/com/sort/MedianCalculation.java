package com.sort;

import java.util.List;
import java.util.Objects;

/**
 * Median Calculation
 *
 * */
public final class MedianCalculation {

    /**
     * Calculate median of given two list
     *
     * @param list1 First list of integer
     * @param list2 Second list of integer
     *
     * @return calculated median value of type {@link Double}
     *
     * **/
    public static double calculateMedian(List<Integer> list1, List<Integer> list2) {

        if (Objects.isNull(list1) || Objects.isNull(list2) || list1.isEmpty() || list2.isEmpty()) {
            throw new IllegalArgumentException("Either one or both lists are null or empty.");
        }

        // Make sure list 1 is smaller than list 2
        if (list1.size() > list2.size()) {
            return calculateMedian(list2, list1);
        }

        int list1Size = list1.size();
        int list2Size = list2.size();

        // Half-length calculation
        int partlyLength = (list1Size + list2Size) / 2;

        int min = 0, max = list1Size;

        while (min <= max) {
            int mid = (min + max) / 2;
            int x = partlyLength - mid;

            if (mid < list1Size && list1.get(mid) < list2.get(x - 1)) {
                min = mid + 1; // if mid is small then increase it.
            } else if (mid > 0 && list1.get(mid - 1) > list2.get(x)) {
                max = mid - 1; // if mid is big then decrease it.
            } else {
                // mid value is correct

                int leftMax = 0;
                int rightMin = 0;

                if (mid == 0) {
                    leftMax = list2.get(x - 1);
                } else if (x == 0) {
                    leftMax = list1.get(mid - 1);
                } else {
                    leftMax = Math.max(list1.get(mid - 1), list2.get(x - 1));
                }

                if ((list1Size + list2Size) % 2 == 1) {
                    // If size of list are odd
                    return leftMax;
                }

                if (mid == list1Size) {
                    rightMin = list2.get(x);
                } else if (x == list2Size) {
                    rightMin = list1.get(mid);
                } else {
                    rightMin = Math.min(list1.get(mid), list2.get(x));
                }

                // if size of list are even
                return (leftMax + rightMin) / 2.0;
            }
        }
        throw new IllegalArgumentException("Input lists are not sorted");
    }
}
