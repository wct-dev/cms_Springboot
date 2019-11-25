package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.Privilege;

/**
 * @program: cms_jd1911
 * @description: 角色拓展类
 **/

public class RoleExtend extends Role {
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
