package com.taoyiluo.springbootquickstarterservice.service;

import com.taoyiluo.springbootquickstarterapi.entity.SignTaskEntity;

import java.util.List;

public interface SignTaskService {
	/**
	 * 查询还未签署的任务
	 * @return
	 */
	List<String> findNoSignTask();

	/**
	 * 将签署任务添加到数据库
	 * @param signTaskEntity
	 * @return
	 */
	String insertSignTask(SignTaskEntity signTaskEntity);
}
