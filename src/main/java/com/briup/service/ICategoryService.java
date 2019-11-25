package com.briup.service;

import java.util.List;

import com.briup.bean.Category;
import com.briup.utils.CustomerException;
/**
 * 文章栏目接口
 * @author Elvira
 *
 */
public interface ICategoryService {
	/**
	 * 查询所有文章栏目
	 * @return
	 */
    List<Category> findAll();
    /**
     * 保存和更新文章栏目
     * @param category
     * @throws CustomerException
     */
    void saveOrUpdate(Category category) throws CustomerException;
    /**
     * 通过id删除栏目
     * @param id
     * @throws CustomerException
     */
    void deleteById(long id) throws CustomerException;
    /**
     * 批量删除文章栏目
     * @param ids
     * @throws CustomerException
     */
    void batchDelete(long[] ids) throws CustomerException;
}
