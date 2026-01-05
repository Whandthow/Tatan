import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();
        ships.add(new Ship("Enterprise", 930.0, ShipType.CARRIER));
        ships.add(new Ship("Arleigh Burke", 9000.0, ShipType.DESTROYER));
        ships.add(new Ship("Seawolf", 9100.0, ShipType.SUBMARINE));
        ships.add(new Ship("Zubr", 550.0, ShipType.DESTROYER));
        ships.add(new Ship("Nimitz", 100000.0, ShipType.CARRIER));
        ships.add(new Ship("Kidd", 9200.0, ShipType.DESTROYER));

        System.out.println("Ships:");
        ships.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nGet Sorted Destroyers");
        getSortedDestroyers(ships).forEach(System.out::println);

        System.out.println("\nPrint Carriers Over 1000");
        printCarriersOver1000(ships);

        System.out.println("\nGet Total Displacement\n"+getTotalDisplacement(ships));

    }

    public static List<Ship> getSortedDestroyers(Collection<Ship> shipers) {
        return shipers.stream()
                .filter(ship -> ship.shipType()==ShipType.DESTROYER)
                .sorted()
                .toList();
    }

    public static void printCarriersOver1000 (Collection<Ship> shipers) {
        shipers.stream()
                .filter(ship->ship.displacement()>1000&&ship.shipType()==ShipType.CARRIER)
                .forEach(System.out::println);
    }

    public static double getTotalDisplacement(Collection<Ship> shipers) {
        return shipers.stream()
                .mapToDouble(Ship::displacement)
                .reduce(0.0,Double::sum);
    }
}