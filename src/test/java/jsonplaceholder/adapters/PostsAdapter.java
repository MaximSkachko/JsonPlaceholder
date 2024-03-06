package jsonplaceholder.adapters;

import com.google.gson.*;
import framework.BaseAdapter;
import io.qameta.allure.Step;
import jsonplaceholder.pojo.PostsPojo;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.google.gson.JsonParser.parseString;

public class PostsAdapter extends BaseAdapter {
    SoftAssert softAssert = new SoftAssert();

    @Step("Get All Posts")
    public void getPosts(String endUri, int status) {
        String response = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        System.out.println("Number of posts: " + jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            Assert.assertTrue(jsonObject.get("id").getAsInt() - i == 1, "Id not found");
        }
    }

    @Step("Add a post")
    public void postPost(PostsPojo postsPojo, String uri, int status) {
        String response = post(gson.toJson(postsPojo), uri, status);
        JsonObject jsonObject = parseString(response).getAsJsonObject();
        int userId = jsonObject.getAsJsonObject().get("userId").getAsInt();
        int id = jsonObject.get("id").getAsInt();
        String title = jsonObject.get("title").getAsString();
        String body = jsonObject.get("body").getAsString();
        softAssert.assertEquals(userId, postsPojo.getUserId(), "UserIds are not equal");
        softAssert.assertEquals(id, postsPojo.getId(), "IDs are not equal");
        softAssert.assertEquals(title, postsPojo.getTitle(), "Titles are not equal");
        softAssert.assertEquals(body, postsPojo.getBody(), "Bodies are not equal");
        softAssert.assertAll();
    }

    @Step("Get specific post")
    public void getSpecificPost(String endUri, String postId, int status) {
        String response = get(endUri, postId, status);
        System.out.println(response);
        JsonObject jsonObject = parseString(response).getAsJsonObject();
        int userId = jsonObject.getAsJsonObject().get("userId").getAsInt();
        int id = jsonObject.get("id").getAsInt();
        String title = jsonObject.get("title").getAsString();
        String body = jsonObject.get("body").getAsString();
        softAssert.assertEquals(userId, 10,  "UserIds are not equal");
        softAssert.assertEquals(id, 99, "IDs are not equal");
        softAssert.assertTrue(!title.isEmpty(), "Titles are not equal");
        softAssert.assertTrue(!body.isEmpty(), "Bodies are not equal");
        softAssert.assertAll();
    }
    @Step("Trying to get post that not exists")
    public void getPostThatNotExists(String endUri, String postId, int status) {
        String response = get(endUri, postId, status);
        JsonObject jsonObject = parseString(response).getAsJsonObject();
        System.out.println(jsonObject);
        softAssert.assertTrue(jsonObject.isEmpty(), "Body is not empty");
        softAssert.assertAll();
    }
}
//@Serialized Name

