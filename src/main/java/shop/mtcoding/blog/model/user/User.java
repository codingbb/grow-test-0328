package shop.mtcoding.blog.model.user;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.model.resume.ResumeResponse;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@NoArgsConstructor
@Table(name = "user_tb")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String myName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phone;
    private String address;
    private LocalDate birth;
    @Column(unique = true)
    private String businessNumber;
    private String photo;
    private String compName;
    private String homepage;
    @Column(nullable = false)
    private Integer role;


    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @Column
    @ColumnDefault("'1e308313-4d3a-4997-b42c-d409e72034ec_noimage.png'")
    private String imgFileName;

    @Builder
    public User(Integer id, String email, String myName, String password, String phone, String address, LocalDate birth, String businessNumber, String photo, String compName, String homepage, Integer role, LocalDate createdAt, String imgFileName) {
        this.id = id;
        this.email = email;
        this.myName = myName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
        this.businessNumber = businessNumber;
        this.compName = compName;
        this.homepage = homepage;
        this.role = role;
        this.createdAt = createdAt;
        this.imgFileName = imgFileName;
    }

    public ResumeResponse.UserDTO toDTO() {
        return ResumeResponse.UserDTO.builder()
                .id(this.id)
                .email(this.email)
                .myName(this.myName)
                .birth(this.birth)
                .address(this.address)
                .imgFileName(this.imgFileName)
                .phone(this.phone)
                .role(this.role)
                .createdAt(this.createdAt)
                .build();
    }

    //회원정보용 업데이트 의미있는 메서드
    public void update(UserRequest.UpdateDTO requestDTO) {
        this.password = requestDTO.getPassword();
        this.birth = requestDTO.getBirth();
        this.phone = requestDTO.getPhone();
        this.address = requestDTO.getAddress();
    }

}



