package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.dao.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.utils.CustomerException;

/**
 * @program: cms_jd1911
 * @description: 栏目业务实现类
 **/
//一定要记得加@Service，不然Springboot框架找不见
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category.getId() != null){
            categoryMapper.updateByPrimaryKey(category);
        } else {
            //判断是否重名
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> list = categoryMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该栏目已经存在");
            }
            categoryMapper.insert(category);
        }
    }

    @Override
    //添加事务
    @Transactional
    public void deleteById(long id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if(category == null){
            throw new CustomerException("所删除的栏目不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void batchDelete(long[] ids) throws CustomerException {
        for(long id : ids){
            this.deleteById(id);
        }
    }
}
