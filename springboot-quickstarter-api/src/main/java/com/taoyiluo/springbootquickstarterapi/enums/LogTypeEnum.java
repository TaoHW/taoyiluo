package com.taoyiluo.springbootquickstarterapi.enums;

public enum LogTypeEnum {
	GJK("http://svc-epoint-cqproject.epoint:8080/cqproject/rest", "新点:", "归集库全量推送"),
	SXK("http://svc-epoint-cqgatewaybuild.epoint:8080/cqgateway/cqsxkrest/rest", "新点:", "事项库"),
	GZMH("http://svc-epoint-cqgatewaybuild.epoint:8080/cqgateway/cqgzmh", "新点:", "工作门户"),
	XDJQ("http://svc-epoint-cqgatewaybuild.epoint:8080/cqgateway/cqsso", "新点:", "新点鉴权"),
	APP("http://intranet-app-ykb-common-service-prod7afecf.app/ykb/common/service", "APP", "代办人");

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
