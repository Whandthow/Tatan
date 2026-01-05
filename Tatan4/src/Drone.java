public record Drone (String id,int range,DroneType droneType) implements Comparable<Drone>  {
    @Override
    public String toString() {
        return "Drone [id= " + id + " range= " + range + " DroneType= " + droneType + "]";
    }
    @Override
    public int compareTo(Drone drone){
        return  this.droneType==drone.droneType?
                Integer.compare(this.range,drone.range):
                this.droneType.compareTo(drone.droneType);
    }
}
