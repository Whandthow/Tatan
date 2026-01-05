import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Tank> tanks = new LinkedList<>();
        tanks.add(new Tank("T-80", 450, TankType.HEAVY));
        tanks.add(new Tank("Leopard 2", 47, TankType.HEAVY));
        tanks.add(new Tank("T-64", 200, TankType.MEDIUM));
        tanks.add(new Tank("AMX-13", 40, TankType.LIGHT));
        tanks.add(new Tank("T-72", 350, TankType.HEAVY));

        System.out.println("Tanks:");
        tanks.forEach(System.out::println);

        System.out.println("\nWrite Tanks Start With T");
        writeTanksStartWithT(tanks);

        System.out.println("\nTanks Armored && Heavy");
        writeTanksArmored(tanks);

        System.out.println("\nAverage armor");
        averageArmor(tanks);
    }
    public static void writeTanksStartWithT(Collection<Tank> tanks) {
        try{
        Files.write(Paths.get("Tank_list_start_with_T.txt"), tanks.stream()
                        .filter(t->t.model().startsWith("T"))
                        .map(Tank::toString)
                        .collect(Collectors.toList()));
            System.out.println("Successfully wrote Tank_list_start_with_T.txt");
        } catch (IOException e) {
            System.out.println("Error writing Tank_list_start_with_T.txt\n"+e.getMessage());;
        }
    }

    public static void writeTanksArmored(Collection<Tank> tanks) {
        tanks.stream()
                .filter(s->s.tankType()==TankType.HEAVY&&s.armorThickness()>50)
                .forEach(System.out::println);
    }

    public static void averageArmor(Collection<Tank> tanks) {
        tanks.stream()
                .mapToInt(Tank::armorThickness)
                .average()
                .ifPresentOrElse(
                         avg->System.out.println("Average armor: "+avg)
                        ,()->System.out.println("List is empty")
                );
    }

}