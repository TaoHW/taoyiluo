package com.taoyiluo.springbootquickstartercontroller.demos.web.test;

import com.alibaba.fastjson.JSONObject;
import com.taoyiluo.springbootquickstarterapi.po.AliResultPO;
import com.taoyiluo.springbootquickstarterapi.properties.IpProperties;
import com.taoyiluo.springbootquickstarterservice.service.RedisTestService;
import io.swagger.annotations.Api;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Taohw
 * @Classname TestController
 * @Description TODO
 * @Date 2024/3/8 14:51
 * @Version V1.0
 */
@RestController
@RequestMapping("/test")
@Api("测试接口")
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

	/**
	 * redis set测试
	 * @param redisKey
	 * @return
	 */
	@PostMapping("/redis/set")
	@ResponseBody
	public AliResultPO<T> redisTestSet(@RequestBody Map<String,Object> redisKey){
		return redisTestService.redisSet(redisKey);
	}

	/**
	 * redis读取测试
	 * @param redisKey
	 * @return
	 */
	@GetMapping("/redis/get")
	public AliResultPO<T> redisTestGet(String redisKey){
		return redisTestService.redisGet(redisKey);
	}

	//枚举读取配置文件
	@GetMapping("/enum/demo")
	public String typeConstantsDemo() {
		String value = IpProperties.LogTypeEnum.getSystemNameTarget("https://cqzwfw.cqdcg.com/cqzwzt/111");
		System.out.println(value);
		return "Value:"+value;
	}
}
