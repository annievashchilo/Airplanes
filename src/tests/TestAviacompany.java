package tests;

import main.Runner;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAviacompany extends BaseTest {

    @BeforeClass(alwaysRun = true)
    private void setUp() {
//        db = DBUtils.getInstance();
        Runner runner = new Runner();
        createCompany("Belavia");
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
        logger.info("Verify that company with specified name was created");

        Assert.assertFalse(company.getName().equals(companyName),
                "Company was not created - > FAIL");
        logger.info("Company was created -> OK");
    }
}
