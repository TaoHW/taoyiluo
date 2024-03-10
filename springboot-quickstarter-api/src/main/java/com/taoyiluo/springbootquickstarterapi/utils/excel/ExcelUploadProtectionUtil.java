package com.taoyiluo.springbootquickstarterapi.utils.excel;

import com.taoyiluo.springbootquickstarterapi.Exception.ali.AliException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
/**
 * @author Taohw
 * @Classname ExcelUploadProtectionUtil
 * @Description TODO
 * @Date 2024/3/9 21:06
 * @Version V1.0
 */
@Component
public class ExcelUploadProtectionUtil {

	// 允许上传的文件类型
	private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(".xls",".xlsx");


	public static boolean isAllowedExtension(String filename) {
		String extension = filename.substring(filename.lastIndexOf(".")).toLowerCase();
		return ALLOWED_EXTENSIONS.contains(extension);
	}

	/**
	 * 上传文件类型限制
	 */
	public void fileUploadProtection(String fileName){
		// 检查上传文件是否是允许的文件类型
		if (!isAllowedExtension(fileName)) {
			throw new AliException(false, "500","上传的文件类型不允许！");
		}
		System.out.println("文件上传成功！");
	}
}

