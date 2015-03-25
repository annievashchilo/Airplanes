package utils;

import java.util.Comparator;

import planes.Plane;

public class RangeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Plane p1 = (Plane) o1;
		Plane p2 = (Plane) o2;
		
		return p1.getRange() < p2.getRange() ? -1 : p1.getRange() == p2.getRange() ? 0 : 1;
    }

}
