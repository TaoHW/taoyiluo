package com.taoyiluo.springbootquickstarterapi.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Taohw
 * @Classname MatterExcelImportEntity
 * @Description TODO
 * @Date 2024/3/9 22:40
 * @Version V1.0
 */
@Data
public class MatterExcelImportEntity {
	@ExcelProperty(value = "序号", index = 0)
	private Integer num;

	@ExcelProperty(value = "事项编码", index = 1)
	private String matterCode;
}
