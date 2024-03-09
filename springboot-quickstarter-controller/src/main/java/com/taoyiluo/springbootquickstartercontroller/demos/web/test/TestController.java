package com.taoyiluo.springbootquickstartercontroller.demos.web.test;

import com.alibaba.fastjson.JSONObject;
import com.taoyiluo.springbootquickstarterapi.po.AliResultPO;
import com.taoyiluo.springbootquickstarterservice.service.RedisTestService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Taohw
 * @Classname TestController
 * @Description TODO
 * @Date 2024/3/8 14:51
 * @Version V1.0
 */
@Controller
public class TestController {
	@Autowired
	private RedisTestService redisTestService;

	@GetMapping("/get")
	public JSONObject test(){
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("data","");
		jsonObject.put("success","true");
		jsonObject.put("errorCode","");
		jsonObject.put("errorMsg","");
		return jsonObject;
	}

	@PostMapping("/redis/set")
	@ResponseBody
	public AliResultPO<T> redisTestSet(@RequestBody Map<String,Object> redisKey){
		return redisTestService.redisSet(redisKey);
	}

	@GetMapping("/redis/get")
	public AliResultPO<T> redisTestGet(String redisKey){
		return redisTestService.redisGet(redisKey);
	}
}
