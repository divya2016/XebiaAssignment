package com.xebia.assignment.service;

import java.util.List;

import com.xebia.assignment.request.CreateArticleRequest;
import com.xebia.assignment.request.UpdateArticleRequest;
import com.xebia.assignment.response.ArticleReadResponse;
import com.xebia.assignment.response.ArticleResponse;
import com.xebia.assignment.response.ServiceResponse;

public interface ArticleService {

	ServiceResponse<ArticleResponse> createArticle(CreateArticleRequest createArticleRequest);

	ServiceResponse<ArticleResponse> updateArticle(UpdateArticleRequest createArticleRequest);

	ServiceResponse<ArticleResponse> getArticle(String id);

	ServiceResponse<ArticleResponse> deleteArticle(String id);

	ServiceResponse<ArticleReadResponse> getReadTime(String id);

	ServiceResponse<List<ArticleResponse>> getAllArticle();

}
