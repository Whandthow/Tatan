import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Radar> radars = new ArrayList<Radar>();
        radars.add(new Radar("R-101", 400, RadarType.GROUND));
        radars.add(new Radar("A-50", 650, RadarType.AIR));
        radars.add(new Radar("S-77", 300, RadarType.SEA));
        radars.add(new Radar("R-202", 1200, RadarType.GROUND));
        radars.add(new Radar("A-100", 800, RadarType.AIR));

        System.out.println("Array list:");
        radars.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nAverage Range:");
        calculateAverageRange(radars);

        saveToFileAsync(radars);
    }

    public static void calculateAverageRange(Collection<Radar> radars) {
        radars.stream()
                .mapToInt(Radar::range)
                .average()
                .ifPresentOrElse(
                        avg -> System.out.println("Average detection range: " + avg + " km"),
                        () -> System.out.println("Collection is empty")
                );
    }

    public static void saveToFileAsync(Collection<Radar> radars) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            try {
                List<String> data = radars.stream()
                        .map(Radar::toString)
                        .toList();

                Files.write(Paths.get("radars_data.txt"), data);
                return "File 'radars_data.txt' saved successfully!";
            } catch (IOException e) {
                return "Error writing to file: " + e.getMessage();
            }
        };

        Future<String> future = executor.submit(task);

        try {
            System.out.println("\nAsync Task Status: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}