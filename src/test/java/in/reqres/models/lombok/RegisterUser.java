package in.reqres.models.lombok;

import lombok.Data;

@Data
public class RegisterUser {
    private String email,
            password;
}