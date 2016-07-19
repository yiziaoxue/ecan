package com.ecan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ecan.annotation.Authority;
import com.ecan.annotation.contract.AuthorityContract;

/** 
 * TODO
 * @author TaneRoom
 * @date 2016年7月19日 下午5:08:58 
 * @version v1.0 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
    	//处理Permission Annotation，实现方法级权限控制  
        HandlerMethod method = (HandlerMethod)handler;  
        Authority auth = method.getMethodAnnotation(Authority.class);  
          
        //如果为空在表示该方法不需要进行权限验证  
        if (auth == null) {  
            return true;  
        }  
          
        //验证是否具有权限  
        if (logger.isInfoEnabled()) {
            logger.info("Method Authority: " + this.dumpAuthority(auth));
        }
        
        // 验证方法安全
        try {
			AuthorityContract.checkPermission(auth);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        
        return true;  
          
     }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view) throws Exception {  
        String contextPath = request.getContextPath();  
        if (view != null) {  
            request.setAttribute("base", contextPath);  
        }  
    }

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
    
	private String dumpAuthority(Authority auth) {
        if (auth != null) {
            return auth.toString();
        }
        return "null";
    } 
	
}
