package com.taoyiluo.springbootquickstarterapi.Exception.ali;


import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author Taohw
 * @Classname AliException
 * @Description Ali能够识别的异常类
 * @Date 2023/8/30 14:49
 * @Version V1.0
 */
public class AliException extends RuntimeException{
	private static final long serialVersionUID = -1L;

	private boolean success;

	private Object data;

	private String errorCode;

	private String errorMsg;

	private List<Object> extraData;

	private String traceId;

	private String env;


	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<Object> getExtraData() {
		return extraData;
	}

	public void setExtraData(List<Object> extraData) {
		this.extraData = extraData;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	// 提供无参数的构造方法
	public AliException() {
	}


	public AliException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public AliException(Throwable arg) {
		super(arg);
	}

	public AliException(AliResultConstant rs) {
		this.errorCode = rs.getErrorCode();
		this.success = rs.getSuccess();
		this.errorMsg = rs.getErrorMsg();
		this.data = rs.getData();
		this.extraData = rs.getDataList();
		this.traceId = rs.getTraceId();
		this.env = rs.getEnv();
	}

	public AliException(AliResultConstant rs, Throwable cause) {
		super(cause);
		this.errorCode = rs.getErrorCode();
		this.success = rs.getSuccess();
		this.errorMsg = rs.getErrorMsg();
		this.data = rs.getData();
		this.extraData = rs.getDataList();
		this.traceId = rs.getTraceId();
		this.env = rs.getEnv();
	}

	public AliException(Boolean success,String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.success = success;
	}

	public AliException(Boolean success,String errorCode, String message) {
		this.errorCode = errorCode;
		this.errorMsg = message;
		this.success = success;
	}

	public AliException(Boolean success,String errorCode, String message, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.success = success;
		this.errorMsg = message;
	}

	public AliException(AliResultConstant rs, Object data) {
		this.errorCode = rs.getErrorCode();
		this.success = rs.getSuccess();
		this.errorMsg = rs.getErrorMsg();
		this.extraData = rs.getDataList();
		this.traceId = rs.getTraceId();
		this.env = rs.getEnv();
		this.data = data;
	}

	public AliException(AliResultConstant rs, Throwable cause, Object data) {
		super(cause);
		this.errorCode = rs.getErrorCode();
		this.success = rs.getSuccess();
		this.errorMsg = rs.getErrorMsg();
		this.extraData = rs.getDataList();
		this.traceId = rs.getTraceId();
		this.env = rs.getEnv();
		this.data = data;
	}

	public AliException(Boolean success,String errorCode, Throwable cause, Object data) {
		super(cause);
		this.errorCode = errorCode;
		this.data = data;
		this.success = success;
	}

	public AliException(Boolean success,String errorCode, String message, Object data) {
		this.errorCode = errorCode;
		this.data = data;
		this.success = success;
		this.errorMsg = message;
	}

	public AliException(Boolean success,String errorCode, String message, Object data,String traceId) {
		this.errorCode = errorCode;
		this.data = data;
		this.success = success;
		this.errorMsg = message;
		this.traceId = traceId;
	}

	public AliException(Boolean success,String errorCode, String message, Object data,String traceId,String env) {
		this.errorCode = errorCode;
		this.data = data;
		this.success = success;
		this.errorMsg = message;
		this.traceId = traceId;
		this.env = env;
	}

	public AliException(Boolean success,String errorCode, String message, Throwable cause, Object data) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMsg = message;
		this.data = data;
		this.success = success;
	}

	public AliException(Boolean success,String errorCode, String message, Throwable cause, Object data,String traceId) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMsg = message;
		this.data = data;
		this.success = success;
		this.traceId = traceId;
	}


	public AliException(Boolean success,String errorCode, String message, Throwable cause, Object data,String traceId,String env)  {
		super(cause);
		this.errorCode = errorCode;
		this.errorMsg = message;
		this.data = data;
		this.success = success;
		this.traceId = traceId;
		this.env = env;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getMessage() {
		return this.errorMsg;
	}

	public Object getData() {
		return this.data;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.errorMsg = message;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		return "AliException(success="+this.success+", errorCode=" + this.getErrorCode() + ", errorMsg=" + this.getMessage() + ", data=" + this.getData() + ")";
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof AliException)) {
			return false;
		} else {
			AliException other = (AliException)o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label47: {
					Object this$errorCode = this.getErrorCode();
					Object other$errorCode = other.getErrorCode();
					if (this$errorCode == null) {
						if (other$errorCode == null) {
							break label47;
						}
					} else if (this$errorCode.equals(other$errorCode)) {
						break label47;
					}

					return false;
				}

				Object this$message = this.getMessage();
				Object other$message = other.getMessage();
				if (this$message == null) {
					if (other$message != null) {
						return false;
					}
				} else if (!this$message.equals(other$message)) {
					return false;
				}

				Object this$data = this.getData();
				Object other$data = other.getData();
				if (this$data == null) {
					if (other$data != null) {
						return false;
					}
				} else if (!this$data.equals(other$data)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof AliException;
	}

	public int hashCode() {
		boolean PRIME = true;
		int result = 1;
		Object $errorCode = this.getErrorCode();
		result = result * 59 + ($errorCode == null ? 43 : $errorCode.hashCode());
		Object $errorMsg = this.getMessage();
		result = result * 59 + ($errorMsg == null ? 43 : $errorMsg.hashCode());
		Object $data = this.getData();
		result = result * 59 + ($data == null ? 43 : $data.hashCode());
		Object $success = this.isSuccess();
		result = result * 59 + ($success == null ? 43 : $success.hashCode());
		return result;
	}
}
