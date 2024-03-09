package com.taoyiluo.springbootquickstarterservice.service.Imp;

import com.taoyiluo.springbootquickstarterapi.po.AliResultPO;
import com.taoyiluo.springbootquickstarterapi.utils.RedisUtil;
import com.taoyiluo.springbootquickstarterservice.service.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @author Taohw
 * @Classname RedisTestServiceImp
 * @Description TODO
 * @Date 2024/3/9 14:27
 * @Version V1.0
 */
@Service
@Slf4j
public class RedisTestServiceImp implements RedisTestService {
	@Autowired
	public RedisUtil redisUtil;
	@Override
	public AliResultPO redisSet(Map<String, Object> redisKey) {
		Set<String> keys = redisKey.keySet();
		String redisSetKey = null;
		for (String key : keys) {
			redisSetKey = key;
		}
		redisUtil.set(redisSetKey,redisKey.get(redisSetKey),3600);
		return AliResultPO.ok(redisSetKey,redisKey.get(redisSetKey));
	}

	@Override
	public AliResultPO redisGet(String redisKey) {
		return AliResultPO.ok(redisUtil.get(redisKey));
	}
}
