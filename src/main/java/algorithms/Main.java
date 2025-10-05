package algorithms;

import java.util.*;
import metrics.CSVWriter;
import util.PrintArray;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = in.nextInt();

        int[] arr = new Random().ints(size, 0, 1000).toArray();

        System.out.println("\nArray (first 30 items):");
        PrintArray.printArray(arr, 30);

        Performance perf = SelectionSort.sort(arr);

        System.out.println("\nSelection Sort Result:");
        PrintArray.printArray(arr, 30);

        System.out.println("\n" + perf);

        CSVWriter.write("SelectionSort", size, perf);
    }
}