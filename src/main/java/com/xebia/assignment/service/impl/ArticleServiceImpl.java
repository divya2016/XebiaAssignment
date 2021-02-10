package com.xebia.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assignment.constants.Constants;
import com.xebia.assignment.request.CreateArticleRequest;
import com.xebia.assignment.request.UpdateArticleRequest;
import com.xebia.assignment.response.ArticleReadResponse;
import com.xebia.assignment.response.ArticleResponse;
import com.xebia.assignment.response.ServiceResponse;
import com.xebia.assignment.service.ArticleService;
import com.xebia.assignment.service.helper.ArticleServiceHelper;

/**
 * This class implements all the service for articles
 * 
 * @author divyarani
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleServiceHelper articleServiceHelper;

	@Override
	public ServiceResponse<ArticleResponse> createArticle(CreateArticleRequest createArticleRequest) {
		ServiceResponse<ArticleResponse> serviceResponse = articleServiceHelper
				.validateCreateRequest(createArticleRequest);
		if (null != serviceResponse && serviceResponse.getStatus().equals(Constants.SUCCESS)) {
			articleServiceHelper.saveArticle(createArticleRequest);
			serviceResponse = new ServiceResponse<>(Constants.SUCCESS, "data save Sucessfully.");
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse<ArticleResponse> updateArticle(UpdateArticleRequest updateArticleRequest) {
		ServiceResponse<ArticleResponse> serviceResponse = articleServiceHelper
				.validateUpdateRequest(updateArticleRequest);
		if (null != serviceResponse && serviceResponse.getStatus().equals(Constants.SUCCESS)) {
			articleServiceHelper.updateArticle(updateArticleRequest);
			serviceResponse = new ServiceResponse<>(Constants.SUCCESS, "data save Sucessfully");
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse<ArticleResponse> getArticle(String id) {
		ServiceResponse<ArticleResponse> serviceResponse = articleServiceHelper.validateId(id);
		if (null != serviceResponse && serviceResponse.getStatus().equals(Constants.SUCCESS)) {
			serviceResponse = articleServiceHelper.prepareResponse(id);
		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse<ArticleResponse> deleteArticle(String id) {
		ServiceResponse<ArticleResponse> serviceResponse = articleServiceHelper.validateId(id);
		if (null != serviceResponse && serviceResponse.getStatus().equals(Constants.SUCCESS)) {
			articleServiceHelper.deleteDocument(id);
			serviceResponse = new ServiceResponse<>(Constants.SUCCESS, "document deleted Suceessfully.");

		}
		return serviceResponse;
	}

	@Override
	public ServiceResponse<ArticleReadResponse> getReadTime(String id) {
		ServiceResponse<ArticleResponse> serviceResponse = articleServiceHelper.validateId(id);
		if (null != serviceResponse && serviceResponse.getStatus().equals(Constants.SUCCESS)) {
			return articleServiceHelper.calculateReadTime(id);
		}
		return new ServiceResponse<>(serviceResponse.getStatus(), serviceResponse.getMessage());
	}

	@Override
	public ServiceResponse<List<ArticleResponse>> getAllArticle() {
		return articleServiceHelper.getAll();
	}

}
