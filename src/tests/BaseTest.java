package tests;

import aviacompanies.Aviacompany;
import org.apache.log4j.Logger;
import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;
import utils.AirplanesUtils;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anny on 21.04.15.
 */
public class BaseTest {

    public final static Logger logger = Logger.getLogger(BaseTest.class);
    public DBUtils db;

    public List<Plane> planes;
    public Aviacompany company;


    public void createCompany(String name) {
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
