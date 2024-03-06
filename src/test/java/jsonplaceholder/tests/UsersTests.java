package jsonplaceholder.tests;

import framework.PropertyReader;
import jsonplaceholder.adapters.UsersAdapter;
import org.testng.annotations.Test;

public class UsersTests {
    PropertyReader propertyReader = new PropertyReader("config.properties");
    @Test
    public void getAllUsers(){
        UsersAdapter userAdapter = new UsersAdapter();
        userAdapter.getUsers(propertyReader.getProperty("END_URI_USERS"), propertyReader.getIntProperty("status200"));
    }
}