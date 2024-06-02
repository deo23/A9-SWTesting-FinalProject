package dummyapi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {

    private RequestSpecification request;
    private Response response;

    @Given("app-id contains the correct value {string}")
    public void setAppId(String appId) {
        request = RestAssured.given()
                             .header("app-id", appId)
                             .header("Content-Type", "application/json"); // Add Content-Type header
    }

    @Given("given base_url variable contains the value {string} in the environment")
    public void setBaseUrl(String baseUrl) {
        request.baseUri(baseUrl);
    }

    @When("the user sends a CREATE request with registered email")
    public void sendCreateRequestWithEmailRegistered() {
        String body = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"}";
        response = request.body(body).post("/user/create");
    }

    @When("the user sends a CREATE request with empty {string}")
    public void sendCreateRequestWithEmptyField(String fieldName) {
        String body = "{\"firstName\":\"\",\"lastName\":\"Smith\",\"email\":\"jane.smith@example.com\",\"title\":\"ms\",\"gender\":\"female\",\"dateOfBirth\":\"1985-05-15\",\"registerDate\":\"2024-04-30\",\"phone\":\"9876543210\",\"picture\":\"https://example.com/profile.jpg\",\"location\":{\"street\":\"456 Elm St\",\"city\":\"Los Angeles\",\"state\":\"CA\",\"country\":\"USA\"}}";
        if (fieldName.equals("firstName")) {
            body = body.replace("\"firstName\":\"\",", "");
        } else if (fieldName.equals("lastName")) {
            body = body.replace("\"lastName\":\"\",", "");
        }
        response = request.body(body).post("/user/create");
    }

    @When("the user sends a CREATE request with empty body")
    public void sendCreateRequestWithEmptyBody() {
        response = request.post("/user/create");
    }

    @When("the user sends a CREATE request with registered email but other fields are valid")
    public void sendCreateRequestWithEmailRegisteredButOtherFieldsValid() {
        String body = "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"title\":\"ms\",\"gender\":\"female\",\"dateOfBirth\":\"1985-05-15\",\"registerDate\":\"2024-04-30\",\"phone\":\"9876543210\",\"picture\":\"https://example.com/profile.jpg\",\"location\":{\"street\":\"456 Elm St\",\"city\":\"Los Angeles\",\"state\":\"CA\",\"country\":\"USA\"}}";
        response = request.body(body).post("/user/create");
    }

    @When("the user sends an CREATE request with empty firstName")
    public void sendCreateRequestWithEmptyFirstName() {
        String body = "{\"firstName\":\"\",\"lastName\":\"Smith\",\"email\":\"jane.smith@example.com\",\"title\":\"ms\",\"gender\":\"female\",\"dateOfBirth\":\"1985-05-15\",\"registerDate\":\"2024-04-30\",\"phone\":\"9876543210\",\"picture\":\"https://example.com/profile.jpg\",\"location\":{\"street\":\"456 Elm St\",\"city\":\"Los Angeles\",\"state\":\"CA\",\"country\":\"USA\"}}";
        response = request.body(body).post("/user/create");
    }

    @When("the user sends an CREATE request with empty lastName")
    public void sendCreateRequestWithEmptyLastName() {
        String body = "{\"firstName\":\"Jane\",\"lastName\":\"\",\"email\":\"jane.doe@example.com\",\"title\":\"ms\",\"gender\":\"female\",\"dateOfBirth\":\"1992-08-20\",\"registerDate\":\"2024-04-30\",\"phone\":\"9876543210\",\"picture\":\"https://example.com/profile.jpg\",\"location\":{\"street\":\"456 Elm St\",\"city\":\"Los Angeles\",\"state\":\"CA\",\"country\":\"USA\"}}";
        response = request.body(body).post("/user/create");
    }

    @Then("the status response should be {int} Bad Request")
    public void verifyStatusBadRequest(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain the error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        response.then().body("error", equalTo(errorMessage));
    }
}
