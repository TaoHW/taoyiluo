package com.taoyiluo.springbootquickstarterapi.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Taohw
 * @Classname AliResultPO
 * @Description TODO
 * @Date 2024/2/29 15:19
 * @Version V1.0
 */
@Data
@NoArgsConstructor
public final class AliResultPO<T> implements Serializable {

	private static final long serialVersionUID = -1L;

	@JsonProperty("data")
	private T data;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("errorMsg")
	private String errorMsg;
	@JsonProperty("errorCode")
	private String errorCode;

	public AliResultPO(Boolean success, String errorCode, String errorMsg, String msg,T data) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.msg = msg;
		this.data = data;
	}
	public AliResultPO(Boolean success,String msg, T data,String errorCode, String errorMsg) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	public AliResultPO(Boolean success,String msg) {
		this.success = success;
		this.msg = msg;
	}

	public AliResultPO(String msg) {
		this.msg = msg;
	}


	public static <T> AliResultPO<T> ok(String msg, T data) {
		return new AliResultPO(true, msg, data,null,null);
	}

	public static <T> AliResultPO<T> ok(T data) {
		return new AliResultPO(true, "success", data,null,null);
	}

	public static <T> AliResultPO<T> fail(String errorCode, String errorMsg) {
		return new AliResultPO(false, errorCode,errorMsg, null, (Object) null);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}

