package com.ai.photo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ai.photo.controller.base.SearchParams;
import com.ai.photo.sdk.model.ImageDto;

public interface AiImageService {
	public Page<ImageDto> retrivePage(PageRequest pageRequest, SearchParams searchParams) throws Exception;
}
