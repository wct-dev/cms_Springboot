package com.briup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.RoleExample;
import com.briup.bean.extend.RoleExtend;
import com.briup.dao.RoleMapper;
import com.briup.dao.extend.RoleExtendMapper;
import com.briup.service.IRoleService;
import com.briup.utils.CustomerException;

/**
 * @program: cms_jd1911
 * @description: 角色实现类
 **/
@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleExtendMapper roleExtendMapper;
    @Override
    public List<Role> findAll() {

        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<RoleExtend> cascadePrivilegeFindAll() {
        return roleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(Role role) throws CustomerException {
        if(role.getId()!=null){
            roleMapper.updateByPrimaryKey(role);
        } else {
            roleMapper.insert(role);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
    }
}
