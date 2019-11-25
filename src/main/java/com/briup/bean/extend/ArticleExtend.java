package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.Comment;

/**
 * @program: cms_jd1911
 * @description: 文章拓展类
 **/
public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECK="未审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核未通过";

    private Category category;
    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
