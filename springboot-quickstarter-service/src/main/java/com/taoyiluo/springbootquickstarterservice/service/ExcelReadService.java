package com.taoyiluo.springbootquickstarterservice.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExcelReadService {
	/**
	 *
	 * @param response
	 * @param file
	 * @throws IOException
	 */
	void readExcel(HttpServletResponse response, MultipartFile file) throws IOException;

	/**
	 * 导出
	 *
	 * @param response
	 * @return
	 */
	void exportExcel(HttpServletResponse response) throws IOException, IllegalAccessException, InstantiationException;
}
