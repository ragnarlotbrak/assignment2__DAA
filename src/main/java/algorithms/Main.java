package algorithms;

import java.util.*;
import metrics.CSVWriter;
import util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Choose algorithm (selection / heap / kadane): ");
            String algo = in.nextLine().trim().toLowerCase();

            System.out.print("Enter array size: ");
            int size = in.nextInt();

            int[] arr = new Random().ints(size, -1000, 1000).toArray();

            System.out.println("\nArray (first 30 items)");
            PrintArray.printArray(arr, 30);

            Performance perf = null;

            if (algo.equals("selection")) {
                perf = SelectionSort.sort(arr);
            } else if (algo.equals("heap")) {
                perf = HeapSort.sort(arr);
            } else if (algo.equals("kadane")) {
                perf = Kadane.run(arr);
            } else {
                System.out.println("Unknown algorithm: " + algo);
                return;
            }

            System.out.println("\nResult of " + algo + ":");
            PrintArray.printArray(arr, 30);

            System.out.println("\n" + perf);
            CSVWriter.write(Capitalize.capitalize(algo), size, perf);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for array size.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
