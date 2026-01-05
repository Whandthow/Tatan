import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<SupplySystem> SupplySystems = new ArrayList(List.of(
                new SupplySystem("S-01", 1000, SupplyType.FUEL),
                new SupplySystem("A-55", 800, SupplyType.AMMUNITION),
                new SupplySystem("s-02", 1200, SupplyType.FOOD),
                new SupplySystem("F-99", 300, SupplyType.FUEL),
                new SupplySystem("D-03", 100, SupplyType.FOOD)
        ));

        System.out.println("SupplySystem List:");
        SupplySystems.forEach(System.out::println);

        System.out.println("\nSystem Has S");
        getSystemHasS(SupplySystems);

        System.out.println("\nBig Fuel Supply Systems");
        getBigFuelSupplySystems(SupplySystems).forEach(System.out::println);

        System.out.println("\nSum capacity Supply Systems");
        System.out.println(sumCapacity(SupplySystems));

    }
    public static void getSystemHasS(Collection<SupplySystem> suppliers){
        suppliers.stream()
                .filter(s->s.id().toLowerCase().contains("s"))
                .forEach(System.out::println);
    }
    public static List<SupplySystem> getBigFuelSupplySystems(Collection<SupplySystem> suppliers){
        return  suppliers.stream()
                .filter(s->s.capacity()>500&&s.supplyType()==SupplyType.FUEL)
                .toList();
    }
    public static int sumCapacity(Collection<SupplySystem> suppliers){
        return suppliers.stream()
                .mapToInt(SupplySystem::capacity)
                .reduce(0, Integer::sum);
    }
}