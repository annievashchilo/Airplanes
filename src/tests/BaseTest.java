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

public class BaseTest {

    public final static Logger logger = Logger.getLogger(BaseTest.class);
    public DBUtils db;

    public List<Plane> planes;
    public Aviacompany company;


    /**
     * create company
     *
     * @param name - name of aviacompany
     * @return representation of aviacompany
     */
    public Aviacompany createCompany(String name) {
        planes = new ArrayList<Plane>();
        company = new Aviacompany(name, constructPlanes());
        System.out.println("Following planes are in park (" + company.getName() + "):");
        AirplanesUtils.printPlanesInfo(company.getAviapark());

        return company;
    }

    /**
     * create new planes
     *
     * @return list of planes
     */
    private List<Plane> constructPlanes() {
        planes.add(new AN12("Lastochka"));
        planes.add(new SuperGuppy("Ribka"));
        planes.add(new AN225("Mriya"));

        return planes;
    }


}
