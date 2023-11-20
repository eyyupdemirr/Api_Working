package Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JSONArrayKullanimi {

     /*
{
"firstName": "John",
"lastName": "doe",
"age": 26,
"address": {
    "streetAddress": "naist street",
    "city": "Nara",
    "postalCode": "630-0192"
            },
"phoneNumbers": [
                {
                    "type": "iPhone",
                    "number": "0123-4567-8888"
                },
                {
                    "type": "home",
                    "number": "0123-4567-8910"
                }
                ]
}
 */

    @Test
    public void jSONarray(){    // en icerden disariya dogru olusturuyoruz

        JSONObject cepTel= new JSONObject();
        cepTel.put("type", "iPhone");
        cepTel.put("number", "0123-4567-8888");


        JSONObject evTel= new JSONObject();
        evTel.put("type", "home");
        evTel.put("number", "0123-4567-8910");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,cepTel);
        phoneNumbers.put(1,evTel);

        JSONObject address=new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");


                // icerdeki inner daki bilgiler bitttigine gore  digerlerini ekleyelim.

        JSONObject personalInfo=new JSONObject();
        personalInfo.put("firstName", "John");
        personalInfo.put("lastName", "doe");
        personalInfo.put("age", 26);
        personalInfo.put("address",address);
        personalInfo.put("phoneNumbers",phoneNumbers);


       System.out.println("personalInfo = " + personalInfo);
        System.out.println("Kisi adi  "+ personalInfo.get("firstName"));
        System.out.println("Kisi soyadi  "+ personalInfo.get("lastName"));
        System.out.println("Kisi yasi  "+ personalInfo.get("age"));
        System.out.println("sokak  "+personalInfo.getJSONObject("address").get("streetAddress"));
        System.out.println("sehir   "+personalInfo.getJSONObject("address").get("city"));
        System.out.println("posta kodu   "+personalInfo.getJSONObject("address").get("postalCode"));
        System.out.println(" cep telefonu  "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println(" cep telefonu   "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));


        System.out.println("ev telefonu  "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("ev telefonu   "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

    }






}
