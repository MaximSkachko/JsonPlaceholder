package jsonplaceholder.adapters;

import com.google.gson.*;
import framework.BaseAdapter;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UsersAdapter extends BaseAdapter {
    SoftAssert softAssert = new SoftAssert();

    @Step("Get All Users")
    public void getUsers(String endUri, int status) {
        String response = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        System.out.println("Number of users: " + jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            Assert.assertTrue(jsonObject.get("id").getAsInt() - i == 1, "Id not found");
            String name = jsonObject.get("name").getAsString();
            String userName = jsonObject.get("username").getAsString();
            String email = jsonObject.get("email").getAsString();
            String street = jsonObject.getAsJsonObject("address").get("street").getAsString();
            String suite = jsonObject.getAsJsonObject("address").get("suite").getAsString();
            String city = jsonObject.getAsJsonObject("address").get("city").getAsString();
            String zipCode = jsonObject.getAsJsonObject("address").get("zipcode").getAsString();
            String lat = jsonObject.getAsJsonObject("address").getAsJsonObject("geo").get("lat").getAsString();
            String lng = jsonObject.getAsJsonObject("address").getAsJsonObject("geo").get("lng").getAsString();
            String phone = jsonObject.get("phone").getAsString();
            String webSite = jsonObject.get("website").getAsString();
            String companyName = jsonObject.getAsJsonObject("company").get("name").getAsString();
            String catchPhrase = jsonObject.getAsJsonObject("company").get("catchPhrase").getAsString();
            String bs = jsonObject.getAsJsonObject("company").get("bs").getAsString();
            if (jsonObject.get("id").getAsInt() == 5) {
                softAssert.assertEquals(name, "Chelsey Dietrich", "Names are not match");
                softAssert.assertEquals(userName, "Kamren", "Usernames are not match");
                softAssert.assertEquals(email, "Lucio_Hettinger@annie.ca", "Emails are not match");
                softAssert.assertEquals(street, "Skiles Walks", "Streets are not match");
                softAssert.assertEquals(suite, "Suite 351", "Suites are not match");
                softAssert.assertEquals(city, "Roscoeview", "Cities are not match");
                softAssert.assertEquals(zipCode, "33263", "ZipCodes are not match");
                softAssert.assertEquals(lat, "-31.8129", "Lats are not match");
                softAssert.assertEquals(lng, "62.5342", "Langs are not match");
                softAssert.assertEquals(phone, "(254)954-1289", "Phones are not match");
                softAssert.assertEquals(webSite, "demarco.info", "Sites are not match");
                softAssert.assertEquals(companyName, "Keebler LLC", "Company names are not match");
                softAssert.assertEquals(catchPhrase, "User-centric fault-tolerant solution", "Catch phrases are not match");
                softAssert.assertEquals(bs, "revolutionize end-to-end systems", "BS are not match");
                softAssert.assertAll();
            }
        }
    }
}