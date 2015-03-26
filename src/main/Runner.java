package main;

import java.util.ArrayList;
import java.util.List;

import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;
import aviacompanies.Aviacompany;



public class Runner {
	
	public static void printPlanesInfo(List<Plane> planes) {
		for (Plane p : planes) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		Plane p1 = new AN12("Lastochka");
		Plane p2 = new AN12("Ptichka");
		Plane p3 = new SuperGuppy("Ribka");
		Plane p4 = new AN225("Mriya");
		
		List<Plane> planes = new ArrayList<Plane>();
		planes.add(p1);
		planes.add(p4);
		planes.add(p3);
		planes.add(p2);
		
		Aviacompany company1 = new Aviacompany("belavia");
		company1.addPlanesToPark(planes);
		System.out.println("Following planes are in park ("+ company1.getName()+"):");
		printPlanesInfo(company1.getAviapark());

		System.out.println("\nPlanes sorted by range");
		List<Plane> sortedPlanes = company1.sortPlanesByRange();
		printPlanesInfo(sortedPlanes);
		

		// looking for a plane by specific charasteristics
		List<Plane> searchResult = company1.findPlane(12999, 55420, 1500, 65000, 5000, 2000);
		
		System.out.println("\nLooking for a specific plane...");
		for (Plane p : searchResult)
		{
			System.out.print("I found:... ");
			System.out.println(p);
		}
	}

}
