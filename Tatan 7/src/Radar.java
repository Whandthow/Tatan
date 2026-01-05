public record Radar(String id,int range,RadarType radarType ) implements Comparable<Radar> {
    @Override
    public int compareTo(Radar o) {
        return Integer.compare(o.range,range);
    }
    @Override
    public String toString() {
        return "Id: "+id+" Range: "+range+" Type: "+radarType;
    }
}
