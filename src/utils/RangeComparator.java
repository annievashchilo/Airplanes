package utils;

import planes.Plane;

import java.util.Comparator;

public class RangeComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        Plane p1 = o1;
        Plane p2 = o2;

        return p1.getRange() < p2.getRange() ? -1 : p1.getRange() == p2.getRange() ? 0 : 1;
    }

}
