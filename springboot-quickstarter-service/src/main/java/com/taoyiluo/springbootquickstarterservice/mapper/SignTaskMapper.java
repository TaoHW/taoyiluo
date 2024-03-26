package com.taoyiluo.springbootquickstarterservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taoyiluo.springbootquickstarterapi.dto.SignTaskDTO;
import com.taoyiluo.springbootquickstarterapi.entity.SignTaskEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;


@Mapper
public interface SignTaskMapper extends BaseMapper<SignTaskEntity> {
	/**
	 *
	 * 获取未签署的列表
	 * @return
	 */
	List<SignTaskDTO> getUnsignTaskList(Date endTime);
}
