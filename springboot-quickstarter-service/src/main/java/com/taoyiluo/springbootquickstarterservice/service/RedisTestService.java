package com.taoyiluo.springbootquickstarterservice.service;

import com.taoyiluo.springbootquickstarterapi.po.AliResultPO;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

public interface RedisTestService {
	/**
	 * 测试redis set
	 * @param redisKey
	 * @return
	 */
	AliResultPO<T> redisSet(Map<String,Object> redisKey);

	/**
	 * 测试redis get
	 * @param redisKey
	 * @return
	 */
	AliResultPO<T> redisGet(String redisKey);
}
