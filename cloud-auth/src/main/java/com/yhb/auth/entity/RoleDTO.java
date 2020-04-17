package com.yhb.auth.entity;

import lombok.Data;

import java.util.Set;

@Data
public class RoleDTO {

    private Long id;

    private String name;

    private Set<PermissionDTO> permissions;

}
