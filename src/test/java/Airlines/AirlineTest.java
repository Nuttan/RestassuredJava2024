package Airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AirlineTest {
        @Test
        public void createAirlineTest() {
        Response response = RestAssured.given().log().all()
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"_id\":\"252d3bca-d9bb-5005d-12c4-562d685e235c\",\n" +
                        "    \"name\": \"Hexagon Airways\",\n" +
                        "    \"country\": \"India\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Hyedrabad\",\n" +
                        "    \"head_quaters\": \"HiTechCity, iNDIA\",\n" +
                        "    \"website\": \"www.hexagonairways.com\",\n" +
                        "    \"established\": \"2024\"\n" +
                        "}")
                .post()
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
