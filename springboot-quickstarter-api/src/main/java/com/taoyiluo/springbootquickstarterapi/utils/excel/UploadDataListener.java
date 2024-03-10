package com.taoyiluo.springbootquickstarterapi.utils.excel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSONObject;

import com.taoyiluo.springbootquickstarterapi.entity.MatterExcelImportEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Taohw
 * @Classname UploadDataListener
 * @Description TODO
 * @Date 2024/3/9 22:43
 * @Version V1.0
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
@Component
public class UploadDataListener implements ReadListener<MatterExcelImportEntity> {
	private static List<MatterExcelImportEntity> cachedDataList = new ArrayList<>();

	/**
	 * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
	 */
	public UploadDataListener() {
	}

	/**
	 * 这个每一条数据解析都会来调用
	 *
	 * @param data    one row value. It is same as {@link AnalysisContext#readRowHolder()}
	 * @param context
	 */
	@Override
	public void invoke(MatterExcelImportEntity data, AnalysisContext context) {
		log.info("解析到一条数据:{}", JSONObject.toJSONString(data));
		cachedDataList.add(data);
		// 达到BATCH_COUNT了，清除内存，容易OOM
		// if (cachedDataList.size() >= BATCH_COUNT) {
		//     // 存储完成清理 list
		//     cachedDataList = newArrayListWithExpectedSize(BATCH_COUNT);
		// }
	}

	public List<MatterExcelImportEntity> getList(){
		return cachedDataList;
	}

	/**
	 * 所有数据解析完成了 都会来调用
	 *
	 * @param context
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		//     // 这里也要保存数据，确保最后遗留的数据也存储到数据库
		//     log.info("所有数据解析完成！");
		// }
	}
}