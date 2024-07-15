package com.mb.user.dto;

import lombok.Data;

@Data
public class SpsUserRolesDTO {

    private String userId;
    private String roleId;

    // Constructors

    public SpsUserRolesDTO() {
    }

    public SpsUserRolesDTO(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
