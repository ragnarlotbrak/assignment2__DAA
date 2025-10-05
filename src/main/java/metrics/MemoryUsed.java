package metrics;

public class MemoryUsed {
    private long memoryUsedKB;

    public void measure() {
        System.gc();
        memoryUsedKB = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
    }

    public long get() { return memoryUsedKB; }
}
