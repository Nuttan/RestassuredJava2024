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
                .body("""
                        {
                            "_id":"252d3bca-d9bb-5005d-12c4-562d685e235c",
                            "name": "Hexagon Airways",
                            "country": "India",
                            "logo": "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                            "slogan": "From Hyedrabad",
                            "head_quaters": "HiTechCity, iNDIA",
                            "website": "www.hexagonairways.com",
                            "established": "2024"
                        }""")
                .post()
                .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
