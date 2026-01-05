import java.util.Comparator;

public class AmmunitionComparator implements Comparator<Ammunition> {
    @Override
    public int compare(Ammunition a1, Ammunition a2) {
        return a1.weight()!= a2.weight()?
                Double.compare(a2.weight(),a1.weight()):
                Double.compare(a2.caliber(),a1.caliber());
    }
}
