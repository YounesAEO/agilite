package org.example.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 *
 * @author Iamyo
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features", glue = "")
public class TestRunner_US01_JouerUnMatch {
}
