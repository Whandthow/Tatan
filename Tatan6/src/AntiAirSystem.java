public record AntiAirSystem(String name,double efficiency,SystemType systemType) {
    @Override
    public String toString() {
        return "Name: " + name + ", Efficiency: " + efficiency + ", System Type: " + systemType;
    }
}
