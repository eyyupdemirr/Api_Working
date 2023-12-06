package Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class C10_Get_ExpectedDataHazirlama {


/*
 https://jsonplaceholder.typicode.com/posts/22 url'ine
 bir GET request yolladigimizda donen response body'sinin
 asagida verilen ile ayni oldugunu test ediniz

Response body :(expected body)
 {
 "userId":3,
 "id":22,
 "title":"dolor sint quo a velit explicabo quia nam",
 "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
 }
  */


    @Test
    public void test01() {

        // 1- Endponit hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2-Expected body hazirla
        JSONObject expBody = new JSONObject();
        expBody.put("userId", 3);
        expBody.put("id", 22);
        expBody.put("title", "dolor sint quo a velit explicabo quia nam");
        expBody.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println(expBody);

        // 3-Response Kaydet

        Response response=given().when().get(url);

        // 4- Assertion yap

        JsonPath respJP=response.jsonPath();    // donen cevabin icindeki verileri incelemek icin response jsonPath objesine yerlestirdik

        Assert.assertEquals(expBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expBody.get("title"),respJP.get("title"));
        Assert.assertEquals(expBody.get("body"),respJP.get("body"));











    }


}
