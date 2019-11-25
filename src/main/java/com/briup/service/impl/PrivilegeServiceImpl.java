package com.briup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Privilege;
import com.briup.bean.PrivilegeExample;
import com.briup.dao.PrivilegeMapper;
import com.briup.dao.extend.PrivilegeExtendMapper;
import com.briup.service.IPrivilegeService;
import com.briup.utils.CustomerException;
import com.briup.vm.PrivilegeTree;

/**
 * @program: cms_jd1911
 * @description: 权限控制实现类
 **/
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;
    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;

    @Override
    public List<Privilege> findAll() {
        return privilegeMapper.selectByExample(new PrivilegeExample());
    }

    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {
        if(privilege.getId()!=null){
            privilegeMapper.updateByPrimaryKey(privilege);
        } else {
            privilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<Privilege> findByParentId(Long parentId) {
        PrivilegeExample example = new PrivilegeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return privilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return privilegeExtendMapper.selectAll();
    }
}
