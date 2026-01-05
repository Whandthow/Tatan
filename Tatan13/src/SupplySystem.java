public record SupplySystem(String id,int capacity,SupplyType supplyType)implements Comparable<SupplySystem> {
    @Override
    public int compareTo(SupplySystem o) {
        return Integer.compare(o.capacity,capacity);
    }
    @Override
    public String toString() {
        return "ID: "+id+" Capacity: "+capacity+" SupplyType: "+supplyType;
    }
}
