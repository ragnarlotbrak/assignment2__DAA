package metrics;

public class Comparisons{
    private long count = 0;

    public void increment() { count++; }
    public void add(long n) { count += n; }
    public long get() { return count; }
    public void reset() { count = 0; }
}
