package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.extend.UserExtend;

public interface UserExtendMapper {
    UserExtend selectById(long id);

    List<UserExtend> selectAll();
}
