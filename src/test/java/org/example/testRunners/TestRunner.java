package org.example.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 *
 * @author Iamyo
 */
@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true, features = "classpath:features", glue = "org.example.stepDefinitions")
public class TestRunner {

}
