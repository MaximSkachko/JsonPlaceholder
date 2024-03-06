package jsonplaceholder.pojo;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsPojo {

    int userId;
    int id;
    String title;
    String body;
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getBody() {
//        return body;
//    }

}
