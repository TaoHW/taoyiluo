package com.taoyiluo.springbootquickstarterapi.properties;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @author Taohw
 * @Classname IpProperties
 * @Description TODO
 * @Date 2024/3/15 16:16
 * @Version V1.0
 */
@Component
public class IpProperties {
	public static String aliMatter;

	@Value("${ip.ali-matter}")
	public void setSpringbootValue(String aliMatter) {
		IpProperties.aliMatter = aliMatter;
	}

	@Value("${ip.ali-matter123}")
	public void setSpringbootValue1(String aliMatter) {
		IpProperties.aliMatter = aliMatter;
	}

	public enum LogTypeEnum {
		GJK(aliMatter, "新点:", "归集库全量推送");

		final String ip;
		final String system;
		final String name;

		LogTypeEnum(String ip, String system, String name) {
			this.ip = ip;
			this.system = system;
			this.name = name;
		}

		public String getIp() {
			return ip;
		}

		public String getSystem() {
			return system;
		}

		public String getName() {
			return name;
		}

		public static String getSystemNameTarget(String targetUrl) {
			LogTypeEnum[] logTypeEnums = LogTypeEnum.values();
			for (LogTypeEnum logTypeEnum : logTypeEnums){
				String ip = logTypeEnum.getIp();
				if (targetUrl.contains(ip)){
					return logTypeEnum.getSystem().concat(logTypeEnum.getName());
				}
			}
			return null;
		}
	}

}