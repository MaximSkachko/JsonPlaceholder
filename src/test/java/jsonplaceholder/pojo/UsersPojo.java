package jsonplaceholder.pojo;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
public class UsersPojo {
    int id;
    String name;
    @SerializedName("username")
    String userName;
    String email;
    String street;
    String suite;
    String city;
    @SerializedName("zipcode")
    String zipCode;
    String lat;
    String lng;
    String phone;
    @SerializedName("website")
    String webSite;
    @SerializedName("name")
    String companyName;
    String catchPhrase;
    String bs;
}