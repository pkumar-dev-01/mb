package com.mb.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sps_user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpsUserRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "atg_role", nullable = false)
    private String roleId;
}
