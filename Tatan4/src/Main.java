import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Drone> drones = new LinkedList<>();
        drones.add(new Drone("D-001", 350, DroneType.COMBAT));
        drones.add(new Drone("R-012", 150, DroneType.RECONNAISSANCE));
        drones.add(new Drone("D-044", 100, DroneType.COMBAT));
        drones.add(new Drone("L-999", 500, DroneType.LOGISTICS));
        drones.add(new Drone("D-102", 400, DroneType.COMBAT));
        drones.add(new Drone("R-005", 200, DroneType.RECONNAISSANCE));

        System.out.println("Linked List sorted");
        drones.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nGet list dones id started with D");
        getIdStartedWithD(drones).forEach(System.out::println);

        System.out.println("\nGet combat dron && range>300");
        getCombatDrons(drones);

        System.out.println("\nGet average range");
        System.out.println(getAverageRange(drones));

    }
    public static List<Drone> getIdStartedWithD(Collection<Drone> drons){
        return drons.stream()
                .filter((d)->d.id().startsWith("D"))
                .skip(1)
                .toList();
    }
    public static void getCombatDrons(Collection<Drone> drons){
        drons.stream()
                .filter((d)->d.range()>300&&d.droneType()==DroneType.COMBAT)
                .forEach(System.out::println);
    }
    public static double getAverageRange(Collection<Drone> drons){
        final double[] avgsn = {0};
        drons.stream()
                .mapToInt(Drone::range)
                .average()
                .ifPresentOrElse(
                        avg ->{
                            System.out.println("Average range: "+avg);
                            avgsn[0] =avg;
                        },
                        ()->{
                            System.out.println("Average range can not by found");
                            avgsn[0] =0.0;
                        }
                );
        return avgsn[0];
    }
}