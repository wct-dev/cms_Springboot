package com.briup.vm;

import java.util.List;

import com.briup.bean.Privilege;

/**
 * @program: cms_jd1911
 * @description: 权限树
 **/

public class PrivilegeTree extends Privilege {
    private List<Privilege> children;

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }
}
