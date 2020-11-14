import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

    }

    /**
     * Sorts a list in-place using bubble sort.
     * 
     * @param <T>  data type to sort
     * @param list given list to sort
     */
    private static void bubbleSort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Passed in list is null and cannot be sorted.");
        }
        int stop = list.size() - 1;
        while (stop > 0) {
            int i = 0;
            int lastSwapped = 0;
            while (i < stop) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    lastSwapped = i;
                }
                i++;
            }
            stop = lastSwapped;
        }
    }

    /**
     * Sorts a list in place using heap sort.
     * 
     * @param <T>  data type to sort
     * @param list given list to sort
     */
    private static void heapSort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Passed in list is null and cannot be sorted.");
        }
    }
}