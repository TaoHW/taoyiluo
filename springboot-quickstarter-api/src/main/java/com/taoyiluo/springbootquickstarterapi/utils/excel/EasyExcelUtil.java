package com.taoyiluo.springbootquickstarterapi.utils.excel;
import com.alibaba.excel.EasyExcel;
import com.taoyiluo.springbootquickstarterapi.Exception.ali.AliException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashSet;
import java.util.List;

/**
 * @author Taohw
 * @Classname EasyExcelUtil
 * @Description TODO
 * @Date 2024/3/9 14:38
 * @Version V1.0
 */

@Component
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EasyExcelUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelUtil.class);

	public static <T> List<T> read(String filePath, final Class<?> clazz, String sheet) {
		File f = new File(filePath);
		try (FileInputStream fis = new FileInputStream(f)) {
			return read(fis, clazz, sheet);
		} catch (FileNotFoundException e) {
			LOGGER.error("文件{}不存在", filePath, e);
		} catch (IOException e) {
			LOGGER.error("文件读取出错", e);
		}
		return null;
	}

	public static <T> List<T> read(InputStream inputStream, final Class<?> clazz, String sheet) {
		if (inputStream == null) {
			throw new AliException("解析出错了，文件流是null");
		}
		// 有个很重要的点 DataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
		DataListener<T> listener = new DataListener<>();// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(inputStream, clazz, listener).sheet(sheet).doRead();
		return listener.getRows();
	}

	public static <T> List<T> read(InputStream inputStream, final Class<?> clazz) {
		if (inputStream == null) {
			throw new AliException("解析出错了，文件流是null");
		}
		// 有个很重要的点 DataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
		DataListener<T> listener = new DataListener<>();// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(inputStream, clazz, listener).doReadAll();
		return listener.getRows();
	}

	public static void write(String outFile, List<?> list) {
		Class<?> clazz = list.get(0).getClass();
		// 新版本会自动关闭流，不需要自己操作
		EasyExcel.write(outFile, clazz).sheet().doWrite(list);
	}

	public static void write(String outFile, List<?> list, String sheetName) {
		Class<?> clazz = list.get(0).getClass();
		// 新版本会自动关闭流，不需要自己操作
		EasyExcel.write(outFile, clazz).sheet(sheetName).doWrite(list);
	}

	public static void write(OutputStream outputStream, List<?> list, String sheetName) {
		Class<?> clazz = list.get(0).getClass();
		// 新版本会自动关闭流，不需要自己操作
		// sheetName为sheet的名字，默认写第一个sheet
		EasyExcel.write(outputStream, clazz).sheet(sheetName).doWrite(list);
	}


	/**
	 * 导出excel
	 * @return 结果
	 */
	public static void download(HttpServletResponse response, Class t, HashSet list) throws IOException, IllegalAccessException,InstantiationException {
		response.setContentType("application/vnd.ms-excel");// 设置文本内省
		response.setCharacterEncoding("utf-8");// 设置字符编码
		response.setHeader("Content-disposition", "attachment;filename=demo.xlsx"); // 设置响应头
		EasyExcel.write(response.getOutputStream(), t).sheet("模板").doWrite(list); //用io流来写入数据
	}

}
