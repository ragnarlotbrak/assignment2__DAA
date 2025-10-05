package metrics;

public class Swaps {
    private long count = 0;

    public void increment() { count++; }
    public long get() { return count; }
    public void reset() { count = 0; }
}
