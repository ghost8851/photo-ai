package com.ai.photo.controller;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.photo.controller.base.BaseController;
import com.ai.photo.controller.base.PropertyUtil;
import com.ai.photo.controller.base.ResultMsg;

@Controller
@RequestMapping("/ai/image/manage")
public class AiImageManageController extends BaseController{

	@Override
	public ResultMsg page(@RequestBody PageRequest pageParam) {
		// TODO Auto-generated method stub
		String aa = PropertyUtil.getPropertyByKey("dbtype");
		String resPath = PropertyUtil.getPropertyByKey("resPath");
		return this.buildSuccess(aa);
	}

	@Override
	public ResultMsg create(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
