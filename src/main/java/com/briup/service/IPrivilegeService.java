package com.briup.service;

import java.util.List;

import com.briup.bean.Privilege;
import com.briup.utils.CustomerException;
import com.briup.vm.PrivilegeTree;

public interface IPrivilegeService {
    
    /** 
     * @Description: 查询所有权限 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     */ 
    List<Privilege> findAll();
    
    /** 
     * @Description: 通过parentId查询权限
     * @Param: [parentId] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     */ 
    List<Privilege> findByParentId(Long parentId);
    
    /** 
     * @Description: 保存或更新权限 
     * @Param: [privilege] 
     * @return: void 
     */ 
    void saveOrUpdate(Privilege privilege) throws CustomerException;

    List<PrivilegeTree> findPrivilegeTree();

}
