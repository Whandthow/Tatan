import java.util.Collection;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeSet<Ammunition> ammunitions = new TreeSet<>(new AmmunitionComparator());
        ammunitions.add(new Ammunition(5.56, 0.012, AmmoType.BULLET));
        ammunitions.add(new Ammunition(155.0, 43.5, AmmoType.SHELL));
        ammunitions.add(new Ammunition(30.0, 0.4, AmmoType.SHELL));
        ammunitions.add(new Ammunition(120.0, 18.0, AmmoType.SHELL));
        ammunitions.add(new Ammunition(300.0, 250.0, AmmoType.MISSILE));
        ammunitions.add(new Ammunition(12.7, 0.11, AmmoType.BULLET));

        System.out.println("Ammunitions: ");
        ammunitions.forEach(System.out::println);

        System.out.println("\nLarge Caliber");
        printLargeCaliber(ammunitions);

        System.out.println("\nHeavy Shells");
        printHeavyShells(ammunitions);

        System.out.println("\nTotal Weight"+getTotalWeight(ammunitions));
    }
    public static void printLargeCaliber(Collection<Ammunition> ammunition) {
        ammunition.stream()
                .filter(a->a.caliber()>50)
                .sorted((o1,o2)->Double.compare(o2.caliber(),o1.caliber()))
                .forEach(System.out::println);
    }
    public static void printHeavyShells(Collection<Ammunition> ammunition) {
        ammunition.stream()
                .filter(a->a.weight()>10&&a.ammoType()==AmmoType.SHELL)
                .forEach(System.out::println);
    }
    public static double getTotalWeight(Collection<Ammunition> ammunition) {
        return ammunition.stream()
                .map(Ammunition::weight)
                .reduce(0.0,Double::sum);
    }
}