package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/** Steps definitions for calculator.feature */
public class StepDefinitions {
    private String server = System.getProperty("calculator.url");

    private RestTemplate restTemplate = new RestTemplate();

    private String a;
    private String b;
    private String result;
    
    //Addition test

    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers(String a, String b) throws Throwable {
        this.a = a;
        this.b = b;
    }

    @When("^the calculator sums them$")
    public void the_calculator_sums_them() throws Throwable {
        String url = String.format("%s/sum?a=%s&b=%s", server, a, b);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(String expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }
    
    //Division test    
    
    private RestTemplate restTemplate2 = new RestTemplate();

    private String a2;
    private String b2;
    private String result2;
    
    @Given("^I have two more numbers: (.*) and (.*)$")
    public void i_have_two_more_numbers(String a2, String b2) throws Throwable {
        this.a = a;
        this.b = b;
    }

    @When("^the calculator divides them$")
    public void the_calculator_divides_them() throws Throwable {
        String url = String.format("%s/div?a=%s&b=%s", server, a2, b2);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_another_result(String expectedResult) throws Throwable {
        assertEquals(expectedResult, result2);
    }
}
