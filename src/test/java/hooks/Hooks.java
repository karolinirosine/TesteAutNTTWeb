package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    public static String featureName;

    @Before
    public void beforeScenario(Scenario scenario) {

        DriverManager.getDriver();

        String uri = scenario.getUri().toString();

        if (uri.contains("login")) {
            featureName = "login";
        } else {
            featureName = "compra";
        }

    }

    @After
    public void afterScenario() {DriverManager.quitDriver();}
}