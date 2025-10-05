package algorithms;

public class HeapSort {
    public static Performance sort(int[] arr) {
        Performance perf = new Performance();
        perf.start();

        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, perf);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, perf);
            heapify(arr, i, 0, perf);
        }

        perf.stop();
        return perf;
    }

    private static void heapify(int[] arr, int n, int i, Performance perf) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n) {
            perf.comparisons.increment();
            if (arr[l] > arr[largest]) largest = l;
        }
        if (r < n) {
            perf.comparisons.increment();
            if (arr[r] > arr[largest]) largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest, perf);
            heapify(arr, n, largest, perf);
        }
    }

    private static void swap(int[] arr, int i, int j, Performance perf) {
        perf.swaps.increment();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
