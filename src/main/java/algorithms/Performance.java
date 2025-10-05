package algorithms;

import metrics.*;

public class Performance {
    public Comparisons comparisons = new Comparisons();
    public Swaps swaps = new Swaps();
    public ArrayAccesses accesses = new ArrayAccesses();
    public MemoryUsed memory = new MemoryUsed();
    public TimeMillis timer = new TimeMillis();

    public void start() {
        memory.measure();
        timer.start();
    }

    public void stop() {
        timer.stop();
        memory.measure();
    }

    @Override
    public String toString() {
        return String.format(
                "Comparisons=%d, Swaps=%d, Accesses=%d, Time=%.3f ms, Memory=%d KB",
                comparisons.get(), swaps.get(), accesses.get(),
                timer.getMillis(), memory.get()
        );
    }
}
