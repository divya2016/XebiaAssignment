package com.xebia.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.assignment.request.CreateArticleRequest;
import com.xebia.assignment.request.UpdateArticleRequest;
import com.xebia.assignment.response.ArticleReadResponse;
import com.xebia.assignment.response.ArticleResponse;
import com.xebia.assignment.response.ServiceResponse;
import com.xebia.assignment.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping("create")
	public ServiceResponse<ArticleResponse> createArticle(@RequestBody CreateArticleRequest createArticleRequest) {
		return articleService.createArticle(createArticleRequest);
	}

	@PostMapping("update")
	public ServiceResponse<ArticleResponse> updateArticle(@RequestBody UpdateArticleRequest updateArticleRequest) {
		return articleService.updateArticle(updateArticleRequest);
	}

	@GetMapping("get/{id}")
	public ServiceResponse<ArticleResponse> getArticle(@PathVariable String id) {
		return articleService.getArticle(id);
	}

	@GetMapping("delete/{id}")
	public ServiceResponse<ArticleResponse> deleteArticle(@PathVariable String id) {
		return articleService.deleteArticle(id);
	}

	@GetMapping("get/read-time/{id}")
	public ServiceResponse<ArticleReadResponse> getReadTime(@PathVariable String id) {
		return articleService.getReadTime(id);
	}

	@GetMapping("getAll")
	public ServiceResponse<List<ArticleResponse>> getAllArticle() {
		return articleService.getAllArticle();
	}

}
