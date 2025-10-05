package metrics;

import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import algorithms.*;

public class CSVWriter {

    private static final String OUTPUT_PATH = "src/docs/performance_results.txt";

    public static void write(String algorithmName, int arraySize, Performance perf) {
        try (FileWriter writer = new FileWriter(OUTPUT_PATH, true)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            nf.setGroupingUsed(true);

            String formatted = String.format(
                    "──────────────────────────────────────────────────────────────\n" +
                            "Timestamp           : %s\n" +
                            "Algorithm           : %s\n" +
                            "Array Size          : %d\n" +
                            "Comparisons         : %s\n" +
                            "Swaps               : %s\n" +
                            "Accesses            : %s\n" +
                            "Execution Time (ms) : %.3f\n" +
                            "Memory Used (KB)    : %s\n" +
                            "──────────────────────────────────────────────────────────────\n\n",
                    timestamp,
                    algorithmName,
                    arraySize,
                    nf.format(perf.comparisons.get()),
                    nf.format(perf.swaps.get()),
                    nf.format(perf.accesses.get()),
                    perf.timer.getMillis(),
                    nf.format(perf.memory.get())
            );

            formatted = formatted.replace("\u00A0", " ");

            writer.write(formatted);
            System.out.println("Results saved to " + OUTPUT_PATH);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
