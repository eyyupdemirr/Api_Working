package Test;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C3_JSON_DataOlusturma {

        /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.
{
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
}
 */

    @Test
    public void Json_Data() {

        JSONObject jsonData = new JSONObject();

        jsonData.put("title", "ahmet");
        jsonData.put("body", "Merhaba");
        jsonData.put("userId", 1);

        System.out.println("ilk olusturdugum jsonData = " + jsonData);


    }
    
    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

{
"firstname":"Jim",
 "additionalneeds":"Breakfast",
 "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                },
"totalprice":111,
"depositpaid":true,
 "lastname":"Brown"
}
 */
    

    @Test
    public void innerJSON() {

        JSONObject innerJSONObj = new JSONObject();
        innerJSONObj.put("checkin", "2018-01-01");
        innerJSONObj.put("checkaut", "2019-01-01");

        JSONObject jsonData=new JSONObject();

        jsonData.put("firstname","Jim");
        jsonData.put("additionalneeds","Breakfast");
        jsonData.put("bookingdates",innerJSONObj);
        jsonData.put("totalprice",111);
        jsonData.put("depositpaid",true);
        jsonData.put("lastname","Brown");

        System.out.println("jsonData = " + jsonData);
        
        
        
        
        
        
        
        
    }


}
