package com.yhb.auth.entity;

import lombok.Data;

@Data
public class RolePermissionDTO {

    private Long id;

    private Long roleId;

    private Long permission_Id;

}
