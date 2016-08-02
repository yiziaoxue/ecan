package com.ecan.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.ecan.annotation.Authority;
import com.ecan.annotation.contract.AuthorityContract;

/**
 * 权限控制拦截器
 * @author TaneRoom
 * @date 2016-07-07 23:49:00
 */
public class AuthorityInterceptor implements MethodInterceptor {
    
	private static final Logger logger = Logger.getLogger(AuthorityInterceptor.class);
    
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Class<?> clazz = method.getDeclaringClass();
        
        if (logger.isInfoEnabled()) {
            logger.info("Start Monitor: " + this.dumpInvocation(clazz, method, invocation.getArguments()));
        }
        
        Authority auth = clazz.getAnnotation(Authority.class);
        if (logger.isInfoEnabled()) {
            logger.info("Class Authority: " + this.dumpAuthority(auth));
        }
        
        // 验证类安全
        AuthorityContract.checkPermission(auth);
        
        auth = method.getAnnotation(Authority.class);
        if (logger.isInfoEnabled()) {
            logger.info("Method Authority: " + this.dumpAuthority(auth));
        }
        
        // 验证方法安全
        AuthorityContract.checkPermission(auth);
        
        return invocation.proceed();
    }
    
    private String dumpInvocation(Class<?> clazz, Method method, Object[] args) {
        StringBuilder txt = new StringBuilder();
        txt.append("[Class: ").append(clazz.getSimpleName()).append("]");
        txt.append("[Method: ").append(method.getName()).append("]");
        txt.append("[Args: ").append(Arrays.toString(args)).append("]");
        
        return txt.toString();
    }
    
    private String dumpAuthority(Authority auth) {
        if (auth != null) {
            return auth.toString();
        }
        return "null";
    } 
}
