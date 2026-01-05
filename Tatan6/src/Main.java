import java.util.Collection;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<AntiAirSystem> PPO = new TreeSet<>(new AntiAirComparator());
        PPO.add(new AntiAirSystem("Patriot", 95.5, SystemType.LONG_RANGE));
        PPO.add(new AntiAirSystem("IRIS-T", 98.0, SystemType.MEDIUM_RANGE));
        PPO.add(new AntiAirSystem("Avenger", 85.0, SystemType.SHORT_RANGE));
        PPO.add(new AntiAirSystem("NASAMS", 92.0, SystemType.MEDIUM_RANGE));
        PPO.add(new AntiAirSystem("Aster 30", 75.0, SystemType.LONG_RANGE));
        PPO.add(new AntiAirSystem("Aspide", 75.0, SystemType.SHORT_RANGE));

        System.out.println("Collection: ");
        PPO.forEach(System.out::println);

        System.out.println("\nFirst Two Starting With A");
        printFirstTwoStartingWithA(PPO);

        System.out.println("\nHigh Efficiency Long Range");
        printHighEfficiencyLongRange(PPO);

        System.out.println("\nMin Efficiency");
        minEfficiency(PPO);
    }
    public static void printFirstTwoStartingWithA(Collection<AntiAirSystem> PPOs) {
        PPOs.stream()
                .filter(pp->pp.name().startsWith("A"))
                .limit(2)
                .forEach(System.out::println);
    }

    public static void printHighEfficiencyLongRange(Collection<AntiAirSystem> PPOs) {
        PPOs.stream()
                .filter(pp->pp.efficiency()>80&&pp.systemType()==SystemType.LONG_RANGE)
                .forEach(System.out::println);
    }

    public static void minEfficiency (Collection<AntiAirSystem> PPOs) {
        PPOs.stream()
                .mapToDouble(AntiAirSystem::efficiency)
                .min()
                .ifPresentOrElse(
                        (min) -> System.out.println("Minimum efficiency: " + min),
                        () -> System.out.println("Array is empty")
                );
    }
}