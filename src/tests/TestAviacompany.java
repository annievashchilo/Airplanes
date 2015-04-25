package tests;

import aviacompanies.Aviacompany;
import main.Runner;
import org.testng.Assert;
import org.testng.annotations.*;
import planes.AN12;
import planes.AN225;
import planes.Plane;
import planes.SuperGuppy;


public class TestAviacompany extends BaseTest {

    protected Aviacompany m_aviacompany;

    @BeforeClass(alwaysRun = true)
    private void setUp() {
//        db = DBUtils.getInstance();
        Runner runner = new Runner();
        m_aviacompany = createCompany("Belavia");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("'Before Method' function was executed.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("'After Class' function was executed.");
    }

    @Parameters({"expectedName"})
    @Test(groups = {"aviacompany"})
    public void testCompanyCreated(String expectedName) {
        logger.info("Verify that company with specified name was created");

        Assert.assertEquals(company.getName(), expectedName,
                "Company was not created - > FAIL");
        logger.info("Company was created -> OK");
    }

    @Parameters({"companyName"})
    @Test(groups = {"aviacompany"})
    public void testCompanyNotCreated(String companyName) {
        logger.info("Verify that company with specified name was NOT created");

        Assert.assertFalse(company.getName().equals(companyName),
                "Company was created - > FAIL");
        logger.info("Company was not created -> OK");
    }

    @Test(groups = {"aviacompany"})
    public void testCommonCapacity() {
        logger.info("Verify common capacity in aviacompany");

        float capacitySumm = 0;
        capacitySumm += new AN12().getCapacity();
        capacitySumm += new AN225().getCapacity();
        capacitySumm += new SuperGuppy().getCapacity();

        Assert.assertEquals(m_aviacompany.getCommonCapacity(), capacitySumm,
                "Capacities are not equal as expected -> FAIL");
        logger.info("Expected and equal capacity are equal -> OK");
    }

    @Parameters({"planeName"})
    @Test(groups = {"aviacompany"})
    public void testSearchPlaneByName(String planeName) {
        logger.info("Verify that expected plane belongs to aviacompany");

        for (Plane plane : m_aviacompany.getAviapark()) {
            if (plane.getName().equals(planeName)) {
                System.out.println("Plane '" + planeName + "' was successfully found -> OK");
                return;
            }
        }
    }


}
