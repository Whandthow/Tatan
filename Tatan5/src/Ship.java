public record Ship(String name, double displacement, ShipType shipType) implements Comparable<Ship> {
    @Override
    public String toString() {
        return "Name: " + name() + ", Displacement: " + displacement() + ", ShipType: " + shipType();
    }
    @Override
    public int compareTo(Ship o) {
        return  Double.compare(o.displacement(),this.displacement());
    }
}
