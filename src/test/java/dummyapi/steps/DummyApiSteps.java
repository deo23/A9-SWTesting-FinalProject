package dummyapi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import io.restassured.response.Response;

public class DummyApiSteps {

    private String appId;
    private String url;
    private int statusCode;
    private String responseBody;

    @Given("no app-id is provided in the request header")
    public void noAppIdIsProvidedInTheRequestHeader() {
        appId = ""; // Set it to an empty string or keep it null and check before adding it to the
                    // request.
    }

    @Given("the wrong app-id in the request header is {string}")
    public void theWrongAppIdInTheRequestHeaderIs(String incorrectAppId) {
        this.appId = incorrectAppId; // Set the incorrect app-id
    }

    @Then("the response body should report {string}")
    public void theResponseBodyShouldReport(String errorMessage) {
        if (appId == null) {
            given()
                    .when()
                    .get(url)
                    .then()
                    .statusCode(403)
                    .body("error", equalTo(errorMessage));
        } else {
            given()
                    .header("app-id", appId)
                    .when()
                    .get(url)
                    .then()
                    .statusCode(403)
                    .body("error", equalTo(errorMessage));
        }
    }

    @Given("the app-id in the request header is {string}")
    public void theAppIdInTheRequestHeaderIs(String appId) {
        this.appId = appId;
    }

    @When("the user sends a GET request to the URL {string}")
    public void theUserSendsAGETRequestToTheURL(String url) {
        this.url = url;
        responseBody = given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .extract()
                .asString();
        statusCode = given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .extract()
                .statusCode();
    }

    @Then("the status response should be {int} Not Found")
    public void theStatusResponseShouldBeNotFound(int expectedStatusCode) {
        assert statusCode == expectedStatusCode;
    }

    @Then("the status response should be {int} OK")
    public void theStatusResponseShouldBeOK(int expectedStatusCode) {
        assert statusCode == expectedStatusCode;
    }

    @Then("the status response should be {int} Forbidden")
    public void theStatusResponseShouldBeForbidden(int expectedStatusCode) {
        assert statusCode == expectedStatusCode;
    }

    @Then("the response body should contain {string} with value {string}")
    public void theResponseBodyShouldContainWithValue(String key, String value) {
        given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .body(key, equalTo(value));
    }

    @Then("the response body should contain user data with ID {string}")
    public void theResponseBodyShouldContainUpdatedUserDataWithID(String userId) {
        given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("title", equalTo("ms"))
                .body("firstName", equalTo("Adina"))
                .body("lastName", equalTo("Barbosa"))
                .body("picture", equalTo("https://randomuser.me/api/portraits/med/women/28.jpg"))
                .body("gender", equalTo("female"))
                .body("email", equalTo("edina.barbosa@example.com"))
                .body("dateOfBirth", equalTo("1952-09-03T13:27:29.424Z"))
                .body("phone", equalTo("(64) 5796-9260"))
                .body("location.street", equalTo("8750, Rua Carlos Gomes"))
                .body("location.city", equalTo("Recife"))
                .body("location.state", equalTo("CearÃ¡"))
                .body("location.country", equalTo("Brazil"))
                .body("location.timezone", equalTo("+1:00"))
                .body("registerDate", equalTo("2021-06-21T21:02:07.719Z"))
                .body("updatedDate", equalTo("2021-06-21T21:02:07.719Z"));
    }

    @Then("the response should contain a list of users and match the expected data structure")
    public void theResponseShouldContainAListOfUsersAndMatchTheExpectedDataStructure() {
        given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("data.size()", greaterThanOrEqualTo(3)) // Checks if there are at least 3 users returned
                .body("data.id",
                        hasItems("60d0fe4f5311236168a109cc", "60d0fe4f5311236168a109cd", "60d0fe4f5311236168a109ce"))
                .body("data.title", hasItems("ms", "mr", "mrs"))
                .body("data.firstName", hasItems("Adina", "Roberto", "Rudi"))
                .body("data.lastName", hasItems("Barbosa", "Vega", "Droste"))
                .body("data.picture", hasItems(
                        "https://randomuser.me/api/portraits/med/women/28.jpg",
                        "https://randomuser.me/api/portraits/med/men/25.jpg",
                        "https://randomuser.me/api/portraits/med/men/83.jpg"));
    }

    @When("the user sends a DELETE request to the URL {string}")
    public void theUserSendsADELETERequestToTheURL(String url) {
        this.url = url;
        Response response;

        if (appId != null && !appId.isEmpty()) {
            response = given()
                    .header("app-id", appId)
                    .when()
                    .delete(url);
        } else {
            response = given()
                    .when()
                    .delete(url);
        }

        statusCode = response.getStatusCode();
        responseBody = response.getBody().asString();
    }

    @Then("the response body should confirm deletion of user ID {string}")
    public void theResponseBodyShouldConfirmDeletionOfUserID(String userId) {
        given()
                .header("app-id", appId)
                .when()
                .get(url)
                .then()
                .statusCode(404)
                .body("error", equalTo("RESOURCE_NOT_FOUND"));
    }

}
