public record Tank(String model,int armorThickness, TankType tankType) implements Comparable<Tank> {
    @Override
    public String toString() {
        return "Model: " + model + " Armor Thickness: " + armorThickness + " Tank Type: " + tankType;
    }
    @Override
    public int compareTo(Tank o) {
        return Integer.compare(o.armorThickness,this.armorThickness);
    }
}
