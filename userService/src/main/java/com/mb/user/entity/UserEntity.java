package com.mb.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "sps_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    
    @Id
    @NotBlank
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "login", nullable = false, length = 40)
    private String login;

    @Column(name = "auto_login")
    private Boolean autoLogin;

    @Size(max = 254)
    @Column(name = "password", length = 254)
    private String password;

    @Size(max = 250)
    @Column(name = "password_salt", length = 250)
    private String passwordSalt;

    @Size(max = 40)
    @Column(name = "password_kdf", length = 40)
    private String passwordKdf;

    @Size(max = 40)
    @Column(name = "realm_id", length = 40)
    private String realmId;

    @Column(name = "member")
    private Boolean member;

    @Size(max = 40)
    @Column(name = "first_name", length = 40)
    private String firstName;

    @Size(max = 40)
    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Size(max = 40)
    @Column(name = "last_name", length = 40)
    private String lastName;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "locale")
    private Integer locale;

    @Column(name = "last_activity_date")
    private LocalDateTime lastActivityDate;

    @Column(name = "last_pwd_update")
    private LocalDateTime lastPwdUpdate;

    @Column(name = "generated_pwd")
    private Boolean generatedPwd;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Email
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "email_status")
    private Integer emailStatus;

    @Column(name = "receive_email")
    private Integer receiveEmail;

    @Column(name = "last_emailed")
    private LocalDateTime lastEmailed;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "security_status")
    private Integer securityStatus;

    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @Size(max = 254)
    @Column(name = "access_token_sign_key", length = 254)
    private String accessTokenSignKey;
}
