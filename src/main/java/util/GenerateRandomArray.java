package util;

import java.util.Random;

public class GenerateRandomArray {
    public static int[] generateRandomArray(int n, int min, int max) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(max - min + 1) + min;
        return a;
    }
}
