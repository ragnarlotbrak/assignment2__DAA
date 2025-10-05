package algorithms;

public class SelectionSort {
    public static Performance sort(int[] arr) {
        Performance perf = new Performance();
        perf.start();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                perf.comparisons.increment();
                perf.accesses.add(2);
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex, perf);
            }
        }
        perf.stop();
        return perf;
    }

    private static void swap(int[] arr, int i, int j, Performance perf) {
        perf.swaps.increment();
        perf.accesses.add(2);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
