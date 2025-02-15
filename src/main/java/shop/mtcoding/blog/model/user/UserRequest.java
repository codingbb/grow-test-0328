package shop.mtcoding.blog.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import shop.mtcoding.blog.model.skill.SkillRequest;

import java.sql.Date;
import java.util.List;
import java.time.LocalDate;

public class UserRequest {

    @Data
    public static class UpdateDTO{
        private String password;
        private String myName;
        private LocalDate birth;
        private String phone;
        private String address;
    }
  
    @Data
    public static class JoinDTO{
        private String email;
        private String myName;
        private String password;
        private String phone;

        public User toEntity (Integer role){
            return User.builder()
                    .email(email)
                    .myName(myName)
                    .password(password)
                    .phone(phone)
                    .role(role)
                    .build();
        }
    }

    @Data
    public static class LoginDTO{
        private String email;
        private String password;
    }
}
