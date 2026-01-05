package org.example;

import java.util.Comparator;

public class MissileSystemComparator implements Comparator<MissileSystem> {
    @Override
    public int compare(MissileSystem o1, MissileSystem o2) {
        return o1.range()!= o2.range()?
                Integer.compare(o2.range(), o1.range())
                :o2.model().compareTo(o1.model());
    }
}
