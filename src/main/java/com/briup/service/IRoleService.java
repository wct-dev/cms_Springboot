package com.briup.service;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.extend.RoleExtend;
import com.briup.utils.CustomerException;

public interface IRoleService {
    /** 
     * @Description: 查询所有角色 
     * @Param: [] 
     * @return: java.util.List<com.briup.bean.BaseRole> 
     */ 
    List<Role> findAll();
    
    /** 
     * @Description: 查询角色级联权限
     * @Param: [] 
     * @return: java.util.List<com.briup.bean.extend.BaseRoleExtend> 
     */ 
    List<RoleExtend> cascadePrivilegeFindAll();
    
    /** 
     * @Description: 保存或更新角色信息 
     * @Param: [baseRole] 
     * @return: void 
     */ 
    void saveOrUpdate(Role baseRole) throws CustomerException;
    
    /** 
     * @Description: 通过id删除角色信息 
     * @Param: [id] 
     * @return: void 
     */ 
    void deleteById(long id) throws CustomerException;
}
