package com.taoyiluo.springbootquickstartercontroller.demos.web.signTask;

import com.taoyiluo.springbootquickstarterapi.entity.SignTaskEntity;
import com.taoyiluo.springbootquickstarterservice.service.SignTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Taohw
 * @Classname SignTaskController
 * @Description TODO
 * @Date 2024/3/21 14:08
 * @Version V1.0
 */
@RequestMapping("/signTask")
@RestController
@Api("签署测试接口")
public class SignTaskController {
	@Autowired
	private SignTaskService signTaskService;

	@PostMapping("/insert")
	@ApiOperation("插入接口")
	@ResponseBody
	public String insert(@RequestBody SignTaskEntity signTaskDTO){
		signTaskDTO.setUpdateTime(new Date());
		return signTaskService.insertSignTask(signTaskDTO);
	}

	@PostMapping("/findNoSignTask")
	@ApiOperation("查找接口")
	@ResponseBody
	public List<String> findNoSignTask(){
		return signTaskService.findNoSignTask();
	}


}
