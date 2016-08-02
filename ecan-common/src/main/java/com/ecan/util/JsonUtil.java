package com.ecan.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 处理前后台信息传递的帮助类
 * @author Tane-Yang
 */
public class JsonUtil {
	
	/**
	 * 把后台处理好的信息传到前台
	 * @param response servlet回应
	 * @param responseStr 回复信息内容
	 * @throws IOException 先抛出,待处理
	 */
	public static void jsonOut(HttpServletResponse response, Object responseStr) throws IOException{
		PrintWriter out=response.getWriter();
		out.print(responseStr);
		out.flush();
		out.close();
	}
	
	/**
	 * 把后台处理好的信息以json的形式传到前台
	 * @param response servlet回应
	 * @param obj 后台处理好的信息
	 */
	public static void writeJson(HttpServletResponse response, Object obj){
		try {
			String json=JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd",SerializerFeature.DisableCircularReferenceDetect);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
