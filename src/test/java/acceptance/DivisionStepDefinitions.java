package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/** Steps definitions for calculator.feature */
public class DivisionStepDefinitions {
    private String server = System.getProperty("calculator.url");

    private RestTemplate restTemplate2 = new RestTemplate();

    private String c;
    private String d;
    private String result2;

    @Given("^I have two more numbers: (.*) and (.*)$")
    public void i_have_two_more_numbers(String c, String d) throws Throwable {
        this.c = c;
        this.d = d;
    }

    @When("^the calculator divides them$")
    public void the_calculator_divs_them() throws Throwable {
        String url = String.format("%s/div?a=%s&b=%s", server, c, d);
        result2 = restTemplate2.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as another result$")
    public void i_receive_as_another_result(String expectedResult2) throws Throwable {
        assertEquals(expectedResult2, result2);
    }
}
