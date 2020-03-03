package com.cihat.trendyol.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        format = {"json:target/cucumber.json"},
        glue = "com.cihat.trendyol.tests")
public class CucumberRunner {
}


