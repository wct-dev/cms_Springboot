package com.briup.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.extend.ArticleExtend;
import com.briup.service.IArticleService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @program: cms_jd1911
 * @description: 文章控制器类
 **/
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private IArticleService articleService;

	// @ApiOperation一般用在方法上，表示方法的意思
	@ApiOperation(value = "查询所有文章")
	@GetMapping("findAll")
	public Message findAll() {
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "级联查询文章", notes = "级联所属栏目，作者")
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAll() {
		List<ArticleExtend> list = articleService.cascadeFindAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "通过id查询")
	@ApiImplicitParams(@ApiImplicitParam(name = "id", value = "主键", paramType = "query"))
	@GetMapping("findById")
	public Message findById(long id) {
		ArticleExtend articleExtend = articleService.findById(id);
		return MessageUtil.success(articleExtend);
	}

	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		articleService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	@ApiOperation(value = "批量删除")
	@PostMapping("batchDelete")
	public Message batchDelete(long[] ids) {
		articleService.batchDelete(ids);
		return MessageUtil.success("删除成功");
	}

	@ApiOperation(value = "保存或更新文章信息", notes = "如果参数中包含id后端认为是更新操作，如果参数中不包含id认为是插入操作")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "编号", paramType = "form", required = false),
			@ApiImplicitParam(name = "title", value = "标题", paramType = "form", required = true),
			@ApiImplicitParam(name = "content", value = "内容", paramType = "form", required = true),
			@ApiImplicitParam(name = "source", value = "源内容", paramType = "form", required = false),
			@ApiImplicitParam(name = "categoryId", value = "所属栏目id", paramType = "form", required = true),
			@ApiImplicitParam(name = "authorId", value = "所属作者id", paramType = "form", required = false) })
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Long id, @NotNull String title, @NotNull String content, String source,
			@NotNull long categoryId, Long authorId) {
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setCategoryId(categoryId);
		article.setAuthorId(authorId);
		articleService.saveOrUpdate(article);
		return MessageUtil.success("更新成功");
	}

}
