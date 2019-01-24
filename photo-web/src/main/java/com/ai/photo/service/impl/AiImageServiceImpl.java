package com.ai.photo.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ai.photo.controller.base.SearchParams;
import com.ai.photo.sdk.model.ImageDto;
import com.ai.photo.service.AiImageService;

@Service
public class AiImageServiceImpl implements AiImageService{

	@Override
	public Page<ImageDto> retrivePage(PageRequest pageRequest, SearchParams searchParams) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
