public record Ammunition(double caliber ,double weight,AmmoType ammoType ) {
    @Override
    public String toString() {
        return "Caliber : "+caliber +" Weight: "+weight+" AmmoType: "+ammoType;
    }
}
