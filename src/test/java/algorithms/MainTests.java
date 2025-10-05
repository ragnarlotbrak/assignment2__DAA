package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTests {

    @Test
    void testSelectionSort() {
        int[] arr = {3, 1, 2};
        int[] expected = {1, 2, 3};
        SelectionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSort() {
        int[] arr = {5, 2, 9, 1};
        int[] expected = {1, 2, 5, 9};
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testKadane() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        int result = Kadane.maxSubarraySum(arr);
        assertEquals(expected, result);
    }

    @Test
    void testMaxHeap() {
        int[] arr = {3, 1, 6, 5, 2, 4};
        MaxHeap maxHeap = new MaxHeap(arr.length);
        maxHeap.buildHeap(arr);
        int[] heap = maxHeap.getHeap();

        for (int i = 0; i < heap.length / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < heap.length) assertTrue(heap[i] >= heap[left]);
            if (right < heap.length) assertTrue(heap[i] >= heap[right]);
        }
    }
}
