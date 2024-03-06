package jsonplaceholder.tests;

import com.github.javafaker.Faker;
import framework.PropertyReader;
import jsonplaceholder.adapters.PostsAdapter;
import jsonplaceholder.pojo.PostsPojo;
import org.testng.annotations.Test;

public class PostsTests {
    PropertyReader propertyReader = new PropertyReader("config.properties");
    @Test
    public void getAllPosts(){
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.getPosts(propertyReader.getProperty("END_URI_POSTS"), propertyReader.getIntProperty("status200"));
    }
    @Test
    public void postPost(){
        Faker faker = new Faker();
        PostsPojo postsPojo = PostsPojo.builder()
                .userId(1)
                .id(101)
                .title(faker.company().name())
                .body("")
                .build();
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.postPost(postsPojo, propertyReader.getProperty("END_URI_POSTS"), propertyReader.getIntProperty("status201"));
    }

    @Test
    public void getOnePost(){
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.getSpecificPost(propertyReader.getProperty("END_URI_POSTS"),"/99", propertyReader.getIntProperty("status200"));
    }
    @Test
    public void getNotExistedPost(){
        PostsAdapter postsAdapter = new PostsAdapter();
        postsAdapter.getPostThatNotExists(propertyReader.getProperty("END_URI_POSTS"),"/150", propertyReader.getIntProperty("status404"));
    }
}