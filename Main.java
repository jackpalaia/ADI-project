import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        File data = new File("data.txt");
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
        lines.add("Total time to sort list (nanoseconds): " + totalTime);
        for (int i : temp) {
            lines.add(Integer.toString(i));
        }
        Path output = Paths.get("BubbleSort.txt");
        Files.write(output, lines);
        
        temp = new ArrayList<>(dataList);
        startTime = System.nanoTime();
        heapSort(temp);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        lines = new ArrayList<>();
        lines.add("Total time to sort list (nanoseconds): " + totalTime);
        for (int i : temp) {
            lines.add(Integer.toString(i));
        }
        output = Paths.get("HeapSort.txt");
        Files.write(output, lines);
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, pq.poll());
        }
    }
}