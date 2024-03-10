package com.taoyiluo.springbootquickstarterapi.Exception.ali;

import com.taoyiluo.springbootquickstarterapi.po.AliResultPO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Taohw
 * @Classname AliExceptionHandler
 * @Description Ali 异常处理类
 * @Date 2023/8/31 14:23
 * @Version V1.0
 */
@RestControllerAdvice
@ConditionalOnClass({DispatcherServlet.class})
public class AliExceptionHandler {

	public AliExceptionHandler(){

	}

	/**
	 * 自定义ali的异常类
	 * @param e
	 * @return
	 */
	@ExceptionHandler({Exception.class})
	public AliResultPO<?> handler(Exception e){
//        AliResultPo<Object> aliResultPo = new AliResultPo();
//        aliResultPo.setErrorCode(e.getErrorCode());
//        aliResultPo.setSuccess(e.isSuccess());
//        aliResultPo.setErrorMsg(e.getErrorMsg());
//        Object data = e.getData();
//        if(Objects.nonNull(data)){
//            aliResultPo.setData(JSONObject.toJSONString(data));
//        }
		return AliResultPO.fail("500", e.getMessage());
	}

}