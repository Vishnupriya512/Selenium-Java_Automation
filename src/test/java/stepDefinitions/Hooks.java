package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utils.BaseClass;
import utils.ReportGenerator;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        BaseClass.initializeDriver();
    }

    @After
    public void tearDown() {

        BaseClass.quitDriver();
    }


}
