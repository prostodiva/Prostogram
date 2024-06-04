package javagram.javagram.model.DTO.request;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    
private UUID id;
private String firstName;
private String lastName;
private String profileName;
private Date createdAt;
private String email;
private String password;

}
