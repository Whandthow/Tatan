import java.util.Comparator;

public class AntiAirComparator implements Comparator<AntiAirSystem> {
    @Override
    public int compare(AntiAirSystem o1, AntiAirSystem o2) {
        return o1.efficiency()!=o2.efficiency()?
                Double.compare(o2.efficiency(), o1.efficiency()):
                o2.name().compareTo(o1.name());
    }

}
