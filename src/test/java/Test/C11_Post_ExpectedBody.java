package Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Post_ExpectedBody {                                                             //  maalesef calismadi


    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : "Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }


                       Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void test01(){
        // 1- Endponit hazırla
        String url="https://restful-booker.herokuapp.com/booking";

        // 2-Expected body hazirla

        JSONObject expBody= new JSONObject();   // ana obje

        JSONObject innerDates= new JSONObject();  // inner obje
        innerDates.put( "checkin","2021-06-01");
        innerDates.put( "checkout","2021-06-10");

        JSONObject innerPersonal=new JSONObject();    // inner obje
        innerPersonal.put("firstname","Ahmet");
        innerPersonal.put("lastname","Bulut");
        innerPersonal.put( "totalprice",500);
        innerPersonal.put("depositpaid",false);
        innerPersonal.put( "additionalneeds","wi-fi");
        innerPersonal.put("bookingdates",innerDates);

        // Expected body icine koyuyoruz
        JSONObject expBody1 = new JSONObject();
        expBody1.put("bookingid",24);
        expBody1.put( "booking",innerPersonal);

        System.out.println(expBody);

        // 3-Response Kaydet
        Response response=given()
                                        .contentType(ContentType.JSON)
                                        .when()
                                        .body(expBody1.toString()).post(url);


        // 4- Assertion yap

        JsonPath resJP=response.jsonPath();

        assertEquals(expBody1.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));








    }




}
/*
//1-
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerDate=new JSONObject();
        innerDate.put("checkin","2021-06-01");
        innerDate.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerDate);
        reqBody.put("additionalneeds","wi-fi");



    //2-

        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody); // beklentimin gönderdiğim ile gelenin aynısı olması olduğu için expData=reqBody





    //3-
        Response response=given()
                                    .contentType(ContentType.JSON)
                                .when()
                                    .body(reqBody.toString()).post(url);





    //4-
        JsonPath resJP=response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));




 */