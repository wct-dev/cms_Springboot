package com.briup.vm;

import java.util.List;

/**
 * 
 * @author Elvira
 *
 */

public class UserRoleVM {
    private Long id;
    private List<Long> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}
