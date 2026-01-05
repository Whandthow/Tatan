package org.example;

public record MissileSystem (String model, int range, MissileType MissileType){
    @Override
    public String toString() {
        return "Model: " + model + ", Range: " + range + ", MissileType: " + MissileType;

    }
}
