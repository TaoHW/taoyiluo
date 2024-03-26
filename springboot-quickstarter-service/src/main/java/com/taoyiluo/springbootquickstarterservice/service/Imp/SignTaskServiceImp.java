package com.taoyiluo.springbootquickstarterservice.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoyiluo.springbootquickstarterapi.dto.SignTaskDTO;
import com.taoyiluo.springbootquickstarterapi.entity.SignTaskEntity;
import com.taoyiluo.springbootquickstarterservice.mapper.SignTaskMapper;
import com.taoyiluo.springbootquickstarterservice.service.SignTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Taohw
 * @Classname SignTaskServiceImp
 * @Description TODO
 * @Date 2024/3/21 13:55
 * @Version V1.0
 */
@Service
public class SignTaskServiceImp extends ServiceImpl<SignTaskMapper, SignTaskEntity> implements SignTaskService {

	@Autowired
	private SignTaskMapper signTaskMapper;

	@Override
	public List<String> findNoSignTask() {
		Date endTime = new Date();
		List<SignTaskDTO> needSignTaskList = signTaskMapper.getUnsignTaskList(endTime);
		List<String> needSignTaskIdList = new ArrayList<>();
		List<String> needSignTaskIdList2 = new ArrayList<>();
		if (needSignTaskList.size() > 0){
			for (int i = 0; i < needSignTaskList.size(); i++){
				if (needSignTaskList.get(i).getEndTime().before(endTime)){
					needSignTaskIdList2.add(needSignTaskList.get(i).getTaskId());
				}else {
					SignTaskDTO SignTaskDTO = needSignTaskList.get(i);
					needSignTaskIdList.add(SignTaskDTO.getTaskId());
				}
			}
			return needSignTaskIdList;
		}else {
			return null;
		}
	}

	@Override
	public String insertSignTask(SignTaskEntity signTaskEntity) {
		// Get the current calendar
		Calendar calendar = Calendar.getInstance();
		// Set the calendar time to the update time of the signTaskEntity
		calendar.setTime(signTaskEntity.getUpdateTime());
		// Add 1 day to the calendar time
		calendar.add(Calendar.DAY_OF_MONTH,2);
		// Get the endTime from the calendar
		Date endTime = calendar.getTime();
		// Set the endTime of the signTaskEntity
		signTaskEntity.setEndTime(endTime);
		// Insert the signTaskEntity into the baseMapper
		baseMapper.insert(signTaskEntity);
		// Return the taskId of the signTaskEntity
		return signTaskEntity.getTaskId();
	}
}
