package in.reqres.models.lombok;

import lombok.Data;

@Data
public class LoginUserBody {
    private String email,
            password;
}