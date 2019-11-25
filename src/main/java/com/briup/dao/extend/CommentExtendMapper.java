package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.Comment;

public interface CommentExtendMapper {
	
	List<Comment> selectByArticleId(long id);
	
	
}
