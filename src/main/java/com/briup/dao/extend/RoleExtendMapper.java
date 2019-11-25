package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.extend.RoleExtend;

/**
 * @program: cms_jd1911
 * @description:
 * @author: charles
 * @create: 2019-11-15 15:13
 **/

public interface RoleExtendMapper {
    List<Role> selectByUserId(long id);

    List<RoleExtend> selectAll();
}
