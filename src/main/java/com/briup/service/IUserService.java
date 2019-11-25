package com.briup.service;

import java.util.List;

import com.briup.bean.User;
import com.briup.bean.extend.UserExtend;
import com.briup.utils.CustomerException;

public interface IUserService {
	/**
     * @Description: 通过id查询
     * @Param: [id]
     * @return: com.briup.bean.extend.BaseUserExtend
     */
    UserExtend findById(long id);

    /**
     * @Description: 查询所有
     * @Param: []
     * @return: java.util.List<com.briup.bean.BaseUser>
     */
    List<User> findAll();
    
    /** 
     * @Description: 级联查询所有
     * @Param: [] 
     * @return: java.util.List<com.briup.bean.extend.BaseUserExtend> 
     */ 
    List<UserExtend> cascadeRoleFindAll();

    /**
     * @Description:  保存或更新
     * @Param: [baseUser]
     * @return: void
     */
    void saveOrUpdate(User user) throws CustomerException;

    /** 
     * @Description: 更新状态
     * @Param: [status] 
     * @return: void 
     */ 
    void changeStatus(long id,String status) throws CustomerException;
    
    /** 
     * @Description: 通过id删除
     * @Param: [id] 
     * @return: void 
     */ 
    void deleteById(long id) throws CustomerException;
    
    /** 
     * @Description: 设置角色
     * @Param: [id, roles] 
     * @return: void 
     */ 
    void setRoles(long id, List<Long> roles);
}
