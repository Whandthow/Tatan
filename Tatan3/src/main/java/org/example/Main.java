package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<MissileSystem> newSystem = new TreeSet<>(new MissileSystemComparator());
        newSystem.add(new MissileSystem("HIMARS", 300, MissileType.MEDIUM_RANGE));
        newSystem.add(new MissileSystem("ATACMS", 165, MissileType.SHORT_RANGE));
        newSystem.add(new MissileSystem("Minuteman III", 13000, MissileType.LONG_RANGE));
        newSystem.add(new MissileSystem("Storm Shadow", 560, MissileType.LONG_RANGE));
        newSystem.add(new MissileSystem("Tochka-U", 120, MissileType.SHORT_RANGE));

        System.out.println("\nSorted by MEDIUM_RANGE");
        filtredByMediumRange(newSystem)
                .forEach(System.out::println);

        System.out.println("\nSorted by LONG_RANGE && range>500");
        filtredByLongestDistance(newSystem);

        System.out.println("\nMin range");
        minRange(newSystem);
    }
    public static List<MissileSystem> filtredByMediumRange(Collection<MissileSystem> systems) {
        return systems.stream()
                .filter((s)->s.MissileType()==MissileType.MEDIUM_RANGE)
                .toList();
    }
    public static void filtredByLongestDistance(Collection<MissileSystem> systems) {
        systems.stream()
                .filter((s)->s.MissileType()==MissileType.LONG_RANGE&&s.range()>500)
                .forEach(System.out::println);
    }
    public static void minRange(Collection<MissileSystem> systems) {
        systems.stream()
                .mapToInt(MissileSystem::range)
                .min()
                .ifPresentOrElse(
                        (min)-> System.out.println("Min range: "+min),
                        ()-> System.out.println("Collection is empty")
                );
    }
}