package com.mb.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactInfoModel {

    @NotBlank
    private String id;

    @Size(max = 40)
    private String userId;

    @Size(max = 40)
    private String prefix;

    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String middleName;

    @Size(max = 40)
    private String lastName;

    @Size(max = 40)
    private String suffix;

    @Size(max = 100)
    private String jobTitle;

    @Size(max = 40)
    private String companyName;

    @Size(max = 50)
    private String address1;

    @Size(max = 50)
    private String address2;

    @Size(max = 50)
    private String address3;

    @Size(max = 30)
    private String city;

    @Size(max = 20)
    private String state;

    @Size(max = 10)
    private String postalCode;

    @Size(max = 40)
    private String county;

    @Size(max = 40)
    private String country;

    @Size(max = 30)
    private String phoneNumber;

    @Size(max = 30)
    private String faxNumber;
}
