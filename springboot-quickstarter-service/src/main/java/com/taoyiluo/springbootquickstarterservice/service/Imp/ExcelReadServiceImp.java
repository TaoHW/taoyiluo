package com.taoyiluo.springbootquickstarterservice.service.Imp;

import com.alibaba.excel.EasyExcel;
import com.taoyiluo.springbootquickstarterapi.entity.MatterExcelImportEntity;
import com.taoyiluo.springbootquickstarterapi.utils.excel.ExcelUploadProtectionUtil;
import com.taoyiluo.springbootquickstarterapi.utils.excel.UploadDataListener;
import com.taoyiluo.springbootquickstarterservice.service.ExcelReadService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Taohw
 * @Classname ExcelReadServiceImp
 * @Description TODO
 * @Date 2024/3/9 16:26
 * @Version V1.0
 */
@Service
@Slf4j
public class ExcelReadServiceImp implements ExcelReadService {

	@Autowired
	private ExcelUploadProtectionUtil excelUploadProtectionUtil;

	@Override
	public void readExcel(HttpServletResponse response, MultipartFile file) throws IOException {
		// 文件上传保护
		excelUploadProtectionUtil.fileUploadProtection(file.getOriginalFilename());
		EasyExcel.read(file.getInputStream(), MatterExcelImportEntity.class, new UploadDataListener()).sheet("Sheet1").doRead();
		List<MatterExcelImportEntity> list = new UploadDataListener().getList();
		log.info("读取到的数据大小：{}", list.size());
		log.info("读取到的数据：{}", Arrays.copyOfRange(list.toArray(), 0, 10));
//		ArrayList<MatterQueryBaseDTO> matterQueryBaseDTOList = new ArrayList<>();
//		for (MatterExcelImportEntity item : list) {
//			AtgBizMatterQueryBycategoryResponse responseData = callbackAtgForMatterServiceImpl.getmatterByDirectory(item.getCategory());
//			List<MatterQueryBaseDTO> MatterQueryBaseDTOS = responseData.getData();
//			// 推送成功事项的数量
//			if (CollectionUtil.isNotEmpty(MatterQueryBaseDTOS)) {
//				matterQueryBaseDTOList.addAll(MatterQueryBaseDTOS);
//			}
//		}
//		this.multiThreadPush(matterQueryBaseDTOList);
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException, IllegalAccessException, InstantiationException {
//		List<RenderMaterialYunying> render = renderMaterialYunYingMapper.selectRenderMaterialYunying();
//		HashSet<Object> objects = new HashSet<>();
//		for (int i = 0; i < render.size(); i++) {
//			ExcelExport excelExport = new ExcelExport(render.get(i).getQxclIsPush(), render.get(i).getMatterName());
//			objects.add(excelExport);
//		}
//		EasyExcelUtil.download(response, ExcelExport.class, objects);
	}
}
