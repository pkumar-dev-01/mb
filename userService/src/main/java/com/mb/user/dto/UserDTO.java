package com.mb.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String login;
    private Boolean autoLogin;
    private String password;
    private String passwordSalt;
    private String passwordKdf;
    private String realmId;
    private Boolean member;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer userType;
    private Integer locale;
    private LocalDateTime lastActivityDate;
    private LocalDateTime lastPwdUpdate;
    private Boolean generatedPwd;
    private LocalDateTime registrationDate;
    private String email;
    private Integer emailStatus;
    private Integer receiveEmail;
    private LocalDateTime lastEmailed;
    private Integer gender;
    private LocalDate dateOfBirth;
    private Integer securityStatus;
    private String description;
    private String accsTknSgnKey;
}
