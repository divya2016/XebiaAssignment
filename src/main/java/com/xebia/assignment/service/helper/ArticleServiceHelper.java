package com.xebia.assignment.service.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assignment.constants.ConfigConstants;
import com.xebia.assignment.constants.Constants;
import com.xebia.assignment.data.model.Articles;
import com.xebia.assignment.request.CreateArticleRequest;
import com.xebia.assignment.request.UpdateArticleRequest;
import com.xebia.assignment.response.ArticleReadResponse;
import com.xebia.assignment.response.ArticleResponse;
import com.xebia.assignment.response.ReadTime;
import com.xebia.assignment.response.ServiceResponse;
import com.xebia.assignment.utils.CommonUtils;

@Service
public class ArticleServiceHelper {

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private ConfigConstants configConstants;

	public ServiceResponse<ArticleResponse> validateCreateRequest(CreateArticleRequest createArticleRequest) {
		if (null == createArticleRequest) {
			return new ServiceResponse<>(Constants.FAILURE, "request can not be empty.");
		}
		if (StringUtils.isEmpty(createArticleRequest.getTitle())) {
			return new ServiceResponse<>(Constants.FAILURE, "Title can not be empty.");
		}
		if (StringUtils.isEmpty(createArticleRequest.getDescription())) {
			return new ServiceResponse<>(Constants.FAILURE, "Description can not be empty.");
		}
		if (StringUtils.isEmpty(createArticleRequest.getBody())) {
			return new ServiceResponse<>(Constants.FAILURE, "Body can not be empty.");
		}
		return new ServiceResponse<>(Constants.SUCCESS, "Request validate Successfully.");
	}

	public void saveArticle(CreateArticleRequest createArticleRequest) {
		Articles article = new Articles(generateSlung(createArticleRequest.getTitle()), createArticleRequest.getTitle(),
				createArticleRequest.getDescription(), createArticleRequest.getBody());
		commonUtils.save(article);
	}

	private String generateSlung(String title) {
		String slung = title.toLowerCase();
		slung = slung.replace(" ", "-");
		return slung;
	}

	public ServiceResponse<ArticleResponse> validateUpdateRequest(UpdateArticleRequest updateArticleRequest) {
		if (null == updateArticleRequest) {
			return new ServiceResponse<>(Constants.FAILURE, "request can not be empty.");
		}
		if (StringUtils.isEmpty(updateArticleRequest.getId())) {
			return new ServiceResponse<>(Constants.FAILURE, "Id can not be empty.");
		} else {
			if (null == getArticle(updateArticleRequest.getId())) {
				return new ServiceResponse<>(Constants.FAILURE, "article not found for Id");
			}
		}
		if (StringUtils.isEmpty(updateArticleRequest.getTitle())) {
			return new ServiceResponse<>(Constants.FAILURE, "Title can not be empty.");
		}
		if (StringUtils.isEmpty(updateArticleRequest.getDescription())) {
			return new ServiceResponse<>(Constants.FAILURE, "Description can not be empty.");
		}
		if (StringUtils.isEmpty(updateArticleRequest.getBody())) {
			return new ServiceResponse<>(Constants.FAILURE, "Body can not be empty.");
		}
		return new ServiceResponse<>(Constants.SUCCESS, "Request validate Successfully.");
	}

	public void updateArticle(UpdateArticleRequest updateArticleRequest) {
		Articles article = getArticle(updateArticleRequest.getId());
		article.setBody(updateArticleRequest.getBody());
		article.setSlug(generateSlung(updateArticleRequest.getTitle()));
		article.setTitle(updateArticleRequest.getTitle());
		article.setDescription(updateArticleRequest.getDescription());
		commonUtils.save(article);
	}

	public Articles getArticle(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return commonUtils.findOne(map, Articles.class);
	}

	public ServiceResponse<ArticleResponse> validateId(String id) {
		if (StringUtils.isEmpty(id)) {
			return new ServiceResponse<>(Constants.FAILURE, "Id can not be empty.");
		} else {
			if (null == getArticle(id)) {
				return new ServiceResponse<>(Constants.FAILURE, "article not found for Id");
			}
		}
		return new ServiceResponse<>(Constants.SUCCESS, "Request validate Successfully.");
	}

	public ServiceResponse<ArticleResponse> prepareResponse(String id) {
		Articles article = getArticle(id);
		return new ServiceResponse<ArticleResponse>(Constants.SUCCESS, "details fetched successfully.",
				new ArticleResponse(article.getTitle(), article.getDescription(), article.getBody(), article.getId(),
						article.getSlug()));
	}

	public void deleteDocument(String id) {
		Articles article = getArticle(id);
		commonUtils.remove(article);
	}

	public ServiceResponse<ArticleReadResponse> calculateReadTime(String id) {
		Articles article = getArticle(id);
		Integer length = article.getBody().split(" ").length;
		length += article.getDescription().split(" ").length;
		length += article.getTitle().split(" ").length;
		Integer time = length / configConstants.getSpeed();
		Integer mintues = time / 60;
		Integer second = time % 60;
		return new ServiceResponse<>(Constants.SUCCESS, "Read Time calculated Successfully",
				new ArticleReadResponse(id, new ReadTime(mintues.toString(), second.toString())));
	}

	public ServiceResponse<List<ArticleResponse>> getAll() {
		List<Articles> list = commonUtils.findAll(Articles.class);
		List<ArticleResponse> response = new ArrayList<>();
		for (Articles article : list) {
			response.add(new ArticleResponse(article.getTitle(), article.getDescription(), article.getBody(),
					article.getId(), article.getSlug()));
		}
		return new ServiceResponse<List<ArticleResponse>>(Constants.SUCCESS, "data fetched successfully.", response);
	}
}
