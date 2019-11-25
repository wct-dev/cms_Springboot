package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.extend.ArticleExtend;
/**
 * 文章拓展映射接口
 * @author Elvira
 *
 */
public interface ArticleExtendMapper {
	/**
	 * 查询所有拓展信息
	 * @return
	 */
	List<ArticleExtend> selectAll();
	/**
	 * 通过id查询文章信息
	 * @param id
	 * @return
	 */
	ArticleExtend selectById(long id);
	
	
}
