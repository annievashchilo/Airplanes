package main;

import aviacompanies.Aviacompany;
import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;
import utils.AirplanesUtils;

import java.util.ArrayList;
import java.util.List;


public class Runner {


    public static void main(String[] args) {
        // create planes
        Plane p1 = new AN12("Lastochka");
        Plane p2 = new AN12("Ptichka");
        Plane p3 = new SuperGuppy("Ribka");
        Plane p4 = new AN225("Mriya");

        List<Plane> planes = new ArrayList<Plane>();
        planes.add(p1);
        planes.add(p4);
        planes.add(p3);
        planes.add(p2);


        // create new company
        Aviacompany company1 = new Aviacompany("belavia");

        // add created above planes to the company
        company1.addPlanesToPark(planes);
        System.out.println("Following planes are in park (" + company1.getName() + "):");
        AirplanesUtils.printPlanesInfo(company1.getAviapark());

        System.out.println("\nPlanes sorted by range:");
        List<Plane> sortedPlanes = AirplanesUtils.sortPlanesByRange(company1.getAviapark());
        AirplanesUtils.printPlanesInfo(sortedPlanes);


        // looking for a plane by specific parameters
        List<Plane> searchResult = company1.findPlane(12999, 55420, 1500, 65000, 5000, 2000);
        System.out.println("\nLooking for a specific plane...");
        for (Plane p : searchResult) {
            System.out.print("I found:... ");
            System.out.println(p);
        }
    }

}
