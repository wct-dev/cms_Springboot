package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.extend.ArticleExtend;
import com.briup.utils.CustomerException;
/**
 * 
 * @author Elvira
 *
 */
public interface IArticleService {
    /** 
     * @Description:
     * @Param: [] 
     * @return: java.util.List<com.briup.bean.Article> 
     */ 
    List<Article> findAll();

    List<ArticleExtend> cascadeFindAll();

    ArticleExtend findById(long id);
    
    void deleteById(long id) throws CustomerException;
    
    void batchDelete(long[] ids) throws CustomerException;

    void saveOrUpdate(Article article) throws CustomerException;
}
