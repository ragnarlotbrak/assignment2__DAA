package algorithms;

import metrics.*;

public class Kadane {

    public static Performance run(int[] arr) {
        Performance perf = new Performance();
        perf.start();

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            perf.comparisons.increment();
            perf.accesses.add(2);

            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        perf.stop();
        System.out.println("Max subarray sum = " + maxSoFar + " (from index " + start + " to " + end + ")");
        return perf;
    }

    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
