package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.extend.ArticleExtend;
import com.briup.dao.ArticleMapper;
import com.briup.dao.extend.ArticleExtendMapper;
import com.briup.service.IArticleService;
import com.briup.utils.CustomerException;

/**
 * 
 * @author Elvira
 *
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerException {
        if(article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        } else {
            // 标题不能重名
            ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());

            List<Article> articles = articleMapper.selectByExample(example);
            if(articles.size()>0){
                throw new CustomerException("标题不能重复");
            }
            // 初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpDown(0l);
            article.setThumpUp(0l);
            articleMapper.insert(article);
        }
    }

	@Override
	public void deleteById(long id) throws CustomerException {
		 Article article = articleMapper.selectByPrimaryKey(id);
	        if(article == null){
	            throw new CustomerException("要删除的栏目不存在");
	        }
	        articleMapper.deleteByPrimaryKey(id);
	}

    @Override
    @Transactional
    public void batchDelete(long[] ids) throws CustomerException {
        for(long id : ids){
            this.deleteById(id);
        }
    }
	
}
