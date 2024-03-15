package com.taoyiluo.springbootquickstartercontroller.demos.web.fileImport;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Taohw
 * @Classname ExcelImportController
 * @Description TODO
 * @Date 2024/3/9 14:36
 * @Version V1.0
 */
@RestController
@RequestMapping("/file")
@Api("文件导入接口")
public class ExcelImportController {

	/**
	 *
	 * @param response
	 * @param file
	 * @throws IOException
	 */
	@PostMapping("/excel/import")
	@ApiOperation("excel导入接口")
	@ResponseBody
	@ApiResponses({@ApiResponse(code = 200, message = "成功", response = R.class)})
	public void excelImport(HttpServletResponse response, MultipartFile file) throws IOException {
	}

	/**
	 * 导出
	 *
	 * @param response res
	 * @return
	 */
	@GetMapping("/export/excel")
	@ApiOperation("导出")
	@ResponseBody
	@ApiResponses({@ApiResponse(code = 200, message = "成功", response = R.class)})
	public void excelExport(HttpServletResponse response) throws IOException, IllegalAccessException, InstantiationException {
	}
}
