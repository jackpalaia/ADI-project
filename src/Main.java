package src;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        File data = new File("input/data.txt");
        Scanner scanner = new Scanner(data);

        List<Integer> dataList = new ArrayList<>();
        while (scanner.hasNext()) {
            dataList.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> temp = new ArrayList<>(dataList);
        long startTime = System.nanoTime();
        bubbleSort(temp);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        List<String> lines = new ArrayList<>();
        lines.add("Bubble sort time complexities - worst case: O(n^2), average case: O(n^2), best case: O(n)");
        lines.add("Total time to sort list - milliseconds: " + (totalTime / 1000000) + ", nanoseconds: " + totalTime);
        for (int i : temp) {
            lines.add(Integer.toString(i));
        }
        Path output = Paths.get("output/BubbleSort.txt");
        Files.write(output, lines);


        temp = new ArrayList<>(dataList);
        startTime = System.nanoTime();
        heapSort(temp);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;

        lines = new ArrayList<>();
        lines.add(
                "Heap sort time complexities - worst case: O(n log n), average case: O(n log n), best case: O(n log n)");
        lines.add("Total time to sort list - milliseconds: " + (totalTime / 1000000) + ", nanoseconds: " + totalTime);
        for (int i : temp) {
            lines.add(Integer.toString(i));
        }
        output = Paths.get("output/HeapSort.txt");
        Files.write(output, lines);

    }

    /**
     * Sorts a list in-place using bubble sort.
     * 
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
     * Sorts a list in place using heap sort (max heap).
     * 
     * @param list given list to sort
     */
    private static void heapSort(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Passed in list is null and cannot be sorted.");
        }
        int size = list.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(list, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            Collections.swap(list, 0, i);
            heapify(list, i, 0);
        }
    }
    /**
     * Brings brings down a node in heap into the correct position in heap.
     * 
     * @param list list containing heap
     * @param size size of heap
     * @param i index of current node in heap
     */
    private static void heapify(List<Integer> list, int size, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && list.get(left) > list.get(max)) {
            max = left;
        }
        if (right < size && list.get(right) > list.get(max)) {
            max = right;
        }
        if (max != i) {
            Collections.swap(list, i, max);
            heapify(list, size, max);
        }
    }
}