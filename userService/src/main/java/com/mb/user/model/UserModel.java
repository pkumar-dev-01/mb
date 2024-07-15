package com.mb.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 40)
    private String login;

    private Boolean autoLogin;

    @Size(max = 254)
    private String password;

    @Size(max = 250)
    private String passwordSalt;

    @Size(max = 40)
    private String passwordKdf;

    @Size(max = 40)
    private String realmId;

    private Boolean member;

    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String middleName;

    @Size(max = 40)
    private String lastName;

    private Integer userType;

    private Integer locale;

    private LocalDateTime lastActivityDate;

    private LocalDateTime lastPwdUpdate;

    private Boolean generatedPwd;

    private LocalDateTime registrationDate;

    @Email
    @Size(max = 255)
    private String email;

    private Integer emailStatus;

    private Integer receiveEmail;

    private LocalDateTime lastEmailed;

    private Integer gender;

    private LocalDate dateOfBirth;

    private Integer securityStatus;

    @Size(max = 254)
    private String description;

    @Size(max = 254)
    private String accessTokenSignKey;
}
