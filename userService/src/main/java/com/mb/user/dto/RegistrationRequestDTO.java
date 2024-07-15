package com.mb.user.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrationRequestDTO {

    @NotBlank(message = "Login cannot be blank")
    private String login;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Must be a valid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private String firstName;
    private String lastName;
    private String middleName;
    private Integer userType;
    private Integer locale;
    private Integer gender;
    private Date dateOfBirth;

    private String prefix;

    @NotBlank(message = "First name cannot be blank")
    private String contactFirstName;

    private String contactMiddleName;

    @NotBlank(message = "Last name cannot be blank")
    private String contactLastName;

    private String suffix;
    private String jobTitle;
    private String companyName;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String postalCode;
    private String county;
    private String country;
    private String phoneNumber;
    private String faxNumber;

    @NotBlank(message = "Role ID cannot be blank")
    private String roleId;
}
