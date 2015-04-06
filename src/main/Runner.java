package main;

import aviacompanies.Aviacompany;
import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;
import utils.AirplanesUtils;
import utils.DBUtils;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Runner {

    protected static Aviacompany company;


    public static void main(String[] args) {

        Runner runner = new Runner();
        redirectOutput();
        runner.createCompany("Belavia");

        runner.sortPlanes();

        System.out.println("\nCommon capacity of all planes of aviacompany: " + company.getCommonCapacity());

        // looking for a plane by specific parameters
        runner.searchPlane(12999, 55420, 1500, 65000, 5000, 20000, 100, 9999999);

//        postAviacompanyToDB();
    }

    private static void redirectOutput() {
        PrintStream out = null;
        try {
            // redirect output to the text file
            out = new PrintStream(new FileOutputStream("output.txt"));
            System.setErr(out);
            System.setOut(out);
        } catch (Exception err) {
            System.err.println("Failed to open log file");
        }
    }

    private static void postAviacompanyToDB() {
        String sql = "DELETE FROM `test`.`aviacompany` WHERE `aviacompany`.`name` = \'razrazraz\'";

        DBUtils dbUtils = DBUtils.getInstance();
        DBUtils.makeRequest(sql);
    }

    private void searchPlane(
            float minCapacity,
            float maxCapacity,
            float minVolume,
            float maxVolume,
            float minRange,
            float maxRange,
            float minSpeed,
            float maxSpeed) {
        System.out.println("\nLooking for a specific plane...");
        List<Plane> searchResult = company.findPlane(
                minCapacity,
                maxCapacity,
                minVolume,
                maxVolume,
                minRange,
                maxRange,
                minSpeed,
                maxSpeed);
        for (Plane p : searchResult) {
            System.out.print("I found:... ");
            System.out.println(p);
        }
    }

    private void sortPlanes() {
        System.out.println("\nPlanes sorted by range:");
        List<Plane> sortedPlanes = AirplanesUtils.sortPlanesByRange(company.getAviapark());
        AirplanesUtils.printPlanesInfo(sortedPlanes);

        System.out.println("\nPlanes sorted by speed:");
        sortedPlanes = AirplanesUtils.sortPlanesBySpeed(company.getAviapark());
        AirplanesUtils.printPlanesInfo(sortedPlanes);
    }

    private void createCompany(String name) {
        //create planes
        List<Plane> planes = new ArrayList<Plane>();
        planes.add(new AN12("Lastochka"));
        planes.add(new AN12("Ptichka"));
        planes.add(new SuperGuppy("Ribka"));
        planes.add(new AN225("Mriya"));

        // create new company
        company = new Aviacompany(name, planes);
        System.out.println("Following planes are in park (" + company.getName() + "):");
        AirplanesUtils.printPlanesInfo(company.getAviapark());
    }

}
