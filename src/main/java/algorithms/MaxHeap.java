package algorithms;

import metrics.*;

public class MaxHeap {
    private int[] heap;
    private int size;
    private Performance perf;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
        perf = new Performance();
    }

    public Performance buildHeap(int[] arr) {
        perf.start();

        heap = new int[arr.length];
        size = arr.length;
        System.arraycopy(arr, 0, heap, 0, arr.length);

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }

        perf.stop();
        return perf;
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        perf.comparisons.add(2);
        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        perf.swaps.increment();
        perf.accesses.add(2);
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int[] getHeap() {
        int[] result = new int[size];
        System.arraycopy(heap, 0, result, 0, size);
        return result;
    }
}
