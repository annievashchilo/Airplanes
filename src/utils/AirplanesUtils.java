package utils;

import planes.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirplanesUtils {


    /**
     * prints all technical info of planes in aviacompany
     *
     * @param planes
     */
    public static void printPlanesInfo(List<Plane> planes) {
        for (Plane p : planes) {
            System.out.println(p);
        }
    }


    /**
     * Method sorts all airplanes in company by range
     *
     * @return list of sorted planes
     */
    public static List<Plane> sortPlanesByRange(List<Plane> planes) {
        List<Plane> sorted = new ArrayList<Plane>();
        sorted.addAll(planes);
        Collections.sort(sorted, new RangeComparator());
        return sorted;
    }
}
