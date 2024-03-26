package com.taoyiluo.springbootquickstarterapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Taohw
 * @Classname SignTaskDTO
 * @Description TODO
 * @Date 2024/3/21 13:52
 * @Version V1.0
 */
@Data
public class SignTaskDTO {
	@ApiModelProperty("主键")
	Long id;

	@ApiModelProperty("任务id")
	String taskId;

	@ApiModelProperty("回调参数")
	String callbackParam;

	@ApiModelProperty("需要签署的人")
	String needSignedName;

	@ApiModelProperty("更新时间")
	Date updateTime;

	@ApiModelProperty("签署截止时间")
	Date endTime;

	@ApiModelProperty("是否完成签署")
	int isSigned;
}

