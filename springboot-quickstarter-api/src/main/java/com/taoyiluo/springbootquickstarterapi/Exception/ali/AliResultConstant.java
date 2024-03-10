package com.taoyiluo.springbootquickstarterapi.Exception.ali;


import java.util.List;

public interface AliResultConstant{
	boolean getSuccess();

	void setSuccess(boolean success);

	Object getData();

	void setData(Object data);

	String getErrorCode();

	void setErrorCode(String errorCode);

	String getErrorMsg();

	void setErrorMsg(String errorMsg);

	List<Object> getDataList();

	void setDataList(List<Object> dataList);

	String getTraceId();

	void setTraceId(String traceId);

	String getEnv();

	void setEnv(String env);
}
