package com.msa.ims.pos

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.{BeforeClass, AfterClass}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions (
  features = Array("src/test/resources/com/msa/ims/pos"),
  glue = Array("com.msa.ims.pos"),
  format = Array("pretty", "html:target/cucumber-report"),
  tags = Array("@Smoke")
)
class RunSmokeTest {
}