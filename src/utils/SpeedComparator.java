package utils;

import planes.Plane;

import java.util.Comparator;

public class SpeedComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        Plane p1 = o1;
        Plane p2 = o2;

        return p1.getSpeed() < p2.getSpeed() ? -1 : p1.getSpeed() == p2.getSpeed() ? 0 : 1;
    }

}