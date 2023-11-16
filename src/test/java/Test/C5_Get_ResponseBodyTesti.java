package Test;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class C5_Get_ResponseBodyTesti {

    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
 donen Response’in
  status code'unun 200,
  ve content type'inin Aplication.JSON,
  ve response body'sinde bulunan userId'nin 5,
  ve response body'sinde bulunan title'in "optio dolor molestias sit"
 oldugunu test edin.
     */

    @Test
    public void bodyTesti() {

        // 1- end point hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- soruda verilmis ise Expected body hazirla

        // 3- donecek Response Kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // Assertion islemi

        response.then()
                .assertThat()
                            .statusCode(200)
                            .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


                        // buradaki Matchers i statik metod olarak ekleyip yazmaktan kurtuluyoruz


        /*
        response.then()
                .assertThat()
                            .statusCode(200)
                            .contentType("application/json; charset=utf-8")
                .body("userId", equalTo(5))
                .body("title",equalTo("optio dolor molestias sit"));





                                    // buradada body tekrarini ortak parenteze alip engelliyoruz
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", equalTo(5),equalTo("optio dolor molestias sit"));


                    */










    }

}
