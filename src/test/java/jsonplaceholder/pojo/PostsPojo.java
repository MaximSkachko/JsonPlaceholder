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
}
