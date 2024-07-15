package com.mb.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "sps_contact_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoEntity {

    @Id
    @NotBlank
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Size(max = 40)
    @Column(name = "user_id", length = 40)
    private String userId;

    @Size(max = 40)
    @Column(name = "prefix", length = 40)
    private String prefix;

    @Size(max = 40)
    @Column(name = "first_name", length = 40)
    private String firstName;

    @Size(max = 40)
    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Size(max = 40)
    @Column(name = "last_name", length = 40)
    private String lastName;

    @Size(max = 40)
    @Column(name = "suffix", length = 40)
    private String suffix;

    @Size(max = 100)
    @Column(name = "job_title", length = 100)
    private String jobTitle;

    @Size(max = 40)
    @Column(name = "company_name", length = 40)
    private String companyName;

    @Size(max = 50)
    @Column(name = "address1", length = 50)
    private String address1;

    @Size(max = 50)
    @Column(name = "address2", length = 50)
    private String address2;

    @Size(max = 50)
    @Column(name = "address3", length = 50)
    private String address3;

    @Size(max = 30)
    @Column(name = "city", length = 30)
    private String city;

    @Size(max = 20)
    @Column(name = "state", length = 20)
    private String state;

    @Size(max = 10)
    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Size(max = 40)
    @Column(name = "county", length = 40)
    private String county;

    @Size(max = 40)
    @Column(name = "country", length = 40)
    private String country;

    @Size(max = 30)
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    @Size(max = 30)
    @Column(name = "fax_number", length = 30)
    private String faxNumber;
}
