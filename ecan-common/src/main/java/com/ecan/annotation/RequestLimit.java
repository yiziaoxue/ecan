package com.ecan.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午4:52:52
* @Description 访问次数限制注解
* 类说明
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//最高优先级
public @interface RequestLimit {
	 /**
     * 
     * 允许访问的次数，默认值MAX_VALUE
     */
    int count() default Integer.MAX_VALUE;

    /**
     * 
     * 时间段，单位为毫秒，默认值一分钟
     */
    long time() default 60000;
}
