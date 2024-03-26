package com.taoyiluo.springbootquickstarterapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Taohw
 * @Classname SignTaskEntity
 * @Description TODO
 * @Date 2024/3/21 13:53
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sign_task")
@ApiModel(value="傲雄签署任务", description="傲雄签署任务信息表")
public class SignTaskEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty("主键")
	@TableId
	String id;

	@ApiModelProperty("任务id")
	@TableField("TASK_ID")
	String taskId;

	@ApiModelProperty("回调参数")
	@TableField("CALLBACK_PARAM")
	String callbackParam;

	@ApiModelProperty("需要签署的人")
	@TableField("NEED_SIGNED_NAME")
	String needSignedName;

	@ApiModelProperty("更新时间")
	@TableField("UPDATE_TIME")
	Date updateTime;

	@ApiModelProperty("签署截止时间")
	@TableField("END_TIME")
	Date endTime;

	@ApiModelProperty("是否完成签署")
	@TableField("IS_SIGNED")
	int isSigned;
}
