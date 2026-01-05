import java.util.ArrayList;
import java.util.Collection;

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
                .forEach(System.out::println);

        System.out.println();
    }

    public static void calculateAverageRange(Collection<Radar> radars) {
        radars.stream()
                .mapToDouble(Radar::range)
                .average()
                .ifPresentOrElse(
                        ave-> {
                            System.out.println("Average range: " + ave);
                        },
                        ()->{
                            System.out.println("List is empty");
                        }

                );
    }

    public static void
}