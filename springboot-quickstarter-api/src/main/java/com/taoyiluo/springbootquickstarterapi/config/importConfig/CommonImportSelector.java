package com.taoyiluo.springbootquickstarterapi.config.importConfig;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taohw
 * @Classname CommonImportSelector
 * @Description 通过import注入的时候，可以重写ImportSelector，以后面返回的类，都会被注入到容器中。在application.yml中使用@Import注解，引入该类CommonImportSelector就可以了。
 * @Date 2024/3/12 10:15
 * @Version V1.0
 */
public class CommonImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
		//return new String[]{"com.taoyiluo.springbootquickstarterapi.config.redisConfig.RedisConfig"};
		//可以写到配置文件里面.读取配置文件写好的配置
//		List<String> imports = new ArrayList<>();
//		InputStream is = CommonImportSelector.class.getClassLoader().getResourceAsStream("redis.properties");
//		BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(is));
//		String line = null;
//		{
//			try {
//				while (!((line = bufferedInputStream.readLine()) != null)) imports.add(line);;
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}finally {
//				if (bufferedInputStream != null) {
//					try {
//						bufferedInputStream.close();
//					} catch (IOException e) {
//						throw new RuntimeException(e);
//					}
//				}
//			}
//		}
//        //读取配置文件
//        //imports.add("com.taoyiluo.springbootquickstarterapi.config.redisConfig.RedisConfig");
//        return imports.toArray(new String[0]);
	}
}
