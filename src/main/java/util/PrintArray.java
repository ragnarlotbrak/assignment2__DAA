package util;

public class PrintArray {
    public static void printArray(int[] a, int limit) {
        int show = Math.min(limit, a.length);
        for (int i = 0; i < show; i++) System.out.print(a[i] + " ");
        if (a.length > limit) System.out.print("...");
        System.out.println();
    }
}
