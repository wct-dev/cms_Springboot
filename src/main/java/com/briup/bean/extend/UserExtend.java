package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.User;

/**
 * @program: cms_jd1911
 * @description: 用户拓展类
 **/

public class UserExtend extends User {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
