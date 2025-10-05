package cli;

import algorithms.*;
import java.util.*;
import java.util.stream.IntStream;

import util.*;

public class BenchmarkRunner {

    public static void runBenchmarks(int[] sizes) {
        String[] algorithms = {"selection", "heap", "kadane"};
        Random rnd = new Random();

        for (String algo : algorithms) {
            System.out.println("\n --- Benchmark: " + Capitalize.capitalize(algo) + "---");//так удобнее не бейте

            for (int size : sizes) {
                int[] randomArr = rnd.ints(size, 1, 1000).toArray();
                runAlgorithm(algo, randomArr, "Random");

                int[] sorted = IntStream.range(0, size).toArray();
                runAlgorithm(algo, sorted, "Sorted");

                int[] reverse = IntStream.iterate(size, i -> i - 1).limit(size).toArray();
                runAlgorithm(algo, reverse, "Reverse-sorted");

                int[] nearly = Arrays.copyOf(sorted, size);
                swapRandomElements(nearly, Math.max(1, size/100)); // небольшое количество перестановок
                runAlgorithm(algo, nearly, "Nearly-sorted");
                System.out.println(" ");
            }
        }
    }

    private static void runAlgorithm(String algo, int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();

        switch (algo) {
            case "selection":
                SelectionSort.sort(copy);
                break;
            case "heap":
                HeapSort.sort(copy);
                break;
            case "kadane":
                Kadane.maxSubarraySum(copy);
                break;
        }

        long end = System.nanoTime();
        double timeMs = (end - start) / 1_000_000.0;
        System.out.printf("Size: %d, Type: %s, Time: %.3f ms%n", arr.length, type, timeMs);
    }

    private static void swapRandomElements(int[] arr, int swaps) {
        Random rnd = new Random();
        for (int i = 0; i < swaps; i++) {
            int a = rnd.nextInt(arr.length);
            int b = rnd.nextInt(arr.length);
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
    }
}
