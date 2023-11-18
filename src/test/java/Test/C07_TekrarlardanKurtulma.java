package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class C07_TekrarlardanKurtulma {

    /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application-json, ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 612,
        ve "depositpaid"in, false,
     ve "additionalneeds"in, "Breakfast" oldugunu test edin
 */

    @Test
    public void nonRepeat() {

        // 1- end point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/115";

        // 2- Expected Body verilmediği için hazırlanmadı


        // 3- Response kaydet
        Response response = given().when().get(url);








        // Asssertion yap

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Susan"),
                        "lastname",equalTo("Jackson"),
                        "totalprice", equalTo(612),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

    }
}
