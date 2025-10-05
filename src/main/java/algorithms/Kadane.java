package algorithms;

public class Kadane {

    public static Performance run(int[] arr) {
        Performance perf = new Performance();
        perf.start();

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < arr.length; i++) {
            perf.comparisons.increment();
            perf.accesses.add(2);

            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                s = i;
            } else {
                maxEndingHere += arr[i];
            }

            perf.comparisons.increment();
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }

        perf.stop();
        System.out.println("Max subarray sum = " + maxSoFar + " (from index " + start + " to " + end + ")");
        return perf;
    }
}
