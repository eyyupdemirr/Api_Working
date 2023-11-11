package Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

import static io.restassured.RestAssured.given;


public class C1_Get_ApiSorgulama {

    /*
C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */

    // 1-url belirleyip url adresine gideceğiz
    // 2-expected data verilmişse expected data hazırlanır
    // 3-Actual data alınacak
    // 4-assertion işlemi

    @Test
    public void get01(){

        // 1-url belirleyip url adresine gideceğiz

String url="https://restful-booker.herokuapp.com/booking/242";

        // 2-expected data acikca verilirse belirlenecek

        // 3-Actual data alınacak

        Response response1=given().when().get(url);    // Sana url verdigimde gidip getir

       // response1.prettyPrint();

        System.out.println("Status Code  "+ response1.statusCode());
        System.out.println("Contetnt Type  "+ response1.contentType());
        System.out.println("Server Header Degeri  "+ response1.getHeader("Server"));
        System.out.println("Status Line  "+ response1.statusLine());
        System.out.println("Get time "+ response1.getTime());


    }










}
