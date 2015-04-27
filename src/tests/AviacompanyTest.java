package tests;

import aviacompanies.Aviacompany;
import exceptions.PlaneNotFoundException;
import org.testng.Assert;
import org.testng.annotations.*;
import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;

import java.util.List;


public class AviacompanyTest extends BaseTest {

    protected Aviacompany m_aviacompany;

    @BeforeClass(alwaysRun = true)
    private void setUp() {
        m_aviacompany = createCompany("Belavia");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("'Before Method' function was executed.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        System.out.println("'After Class' function was executed.");
    }

    @Parameters({"expectedName"})
    @Test(groups = {"aviacompany"})
    public void testCompanyCreated(String expectedName) {
        System.out.println("Verify that company with specified name was created");

        Assert.assertEquals(company.getName(), expectedName,
                "Company was not created - > FAIL");
        System.out.println("Company was created -> OK");
    }

    @Parameters({"companyName"})
    @Test(groups = {"aviacompany"})
    public void testCompanyNotCreated(@Optional String companyName) {
        System.out.println("Verify that company with specified name was NOT created");

        Assert.assertFalse(company.getName().equals(companyName),
                "Company was created - > FAIL");
        System.out.println("Company was not created -> OK");
    }

    @Test(groups = {"aviacompany"})
    public void testCommonCapacity() {
        System.out.println("Verify common capacity in aviacompany");

        float capacitySumm = 0;
        capacitySumm += new AN12().getCapacity();
        capacitySumm += new AN225().getCapacity();
        capacitySumm += new SuperGuppy().getCapacity();

        Assert.assertEquals(m_aviacompany.getCommonCapacity(), capacitySumm,
                "Capacities are not equal as expected -> FAIL");
        System.out.println("Expected and equal capacity are equal -> OK");
    }

    @Parameters({"planeName"})
    @Test(groups = {"aviacompany"})
    public void testSearchPlaneByName(@Optional String planeName) {
        System.out.println("Verify that expected plane belongs to aviacompany");

        for (Plane plane : m_aviacompany.getAviapark()) {
            if (plane.getName().equals(planeName)) {
                System.out.println("Plane '" + planeName +
                        "' was successfully found -> OK");
                return;
            }
        }
    }


    @Parameters({
            "minCapacity",
            "maxCapacity",
            "minVolume",
            "maxVolume",
            "minRange",
            "maxRange",
            "minSpeed",
            "maxSpeed"})
    @Test(groups = {"aviacompany"}, expectedExceptions = PlaneNotFoundException.class)
    public void testFindPlane(
            float minCapacity,
            float maxCapacity,
            float minVolume,
            float maxVolume,
            float minRange,
            float maxRange,
            float minSpeed,
            float maxSpeed) throws PlaneNotFoundException {
        System.out.println("Test searching for a plane " +
                "by technical characteristics");

        List<Plane> searchResult = company.findPlane(
                minCapacity,
                maxCapacity,
                minVolume,
                maxVolume,
                minRange,
                maxRange,
                minSpeed,
                maxSpeed);
        Assert.assertNotNull(searchResult, "No planes were found -> FAIL!");
        for (Plane p : searchResult) {
            System.out.print("Plane found:... -> OK!");
            System.out.println(p);
        }
    }

    @Parameters("isEmpty")
    @Test(groups = "aviacompany", dependsOnMethods = "testCompanyCreated",
            enabled = false)
    public void testGetAviapark(@Optional String isEmpty) {
        System.out.println("Verify that aviapark in company is not empty");

        Assert.assertNotNull(company.getAviapark());
    }

    @Parameters("planeName")
    @Test(groups = "aviacompany")
    public void testAddPlaneToPark(String planeName) {

        Plane p = new Plane(planeName);
        company.addPlaneToPark(p);

        Assert.assertTrue(company.getAviapark().contains(p),
                "Plane was not added -> FAIL!");
        System.out.println("Plane was added -> OK!");
    }
}
