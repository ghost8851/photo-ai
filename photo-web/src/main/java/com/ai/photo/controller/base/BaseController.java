package com.ai.photo.controller.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public abstract class  BaseController<T> {
	/**
	 * 包装错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public ResultMsg buildError(String msg) {
		ResultMsg errorResponse = new ResultMsg();
		errorResponse.setFail(msg);
		return errorResponse;
	}

	/**
	 * 包装成功返回信息
	 *
	 * @param value
	 * @return
	 */
	public ResultMsg buildSuccess(Object value) {
		ResultMsg response = new ResultMsg();
		response.setSuccess(value);
		return response;
	}

	/**
	 * 包装成功返回信息
	 *
	 * @return
	 */
	public ResultMsg buildSuccess() {
		ResultMsg response = new ResultMsg();
		response.setSuccess();
		return response;
	}

	@RequestMapping(value = "/page", method = RequestMethod.POST)
	@ResponseBody
	public abstract ResultMsg page(@RequestBody PageRequest pageParam);

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public abstract ResultMsg create(@RequestBody T entity);

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public abstract ResultMsg update(@RequestBody T entity);

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public abstract ResultMsg delete(@RequestBody T entity);

	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	@ResponseBody
	public abstract ResultMsg delete(@RequestBody String id);

	@RequestMapping(value = "/getById", method = { RequestMethod.POST })
	@ResponseBody
	public abstract ResultMsg getById(@RequestBody String id);

}
