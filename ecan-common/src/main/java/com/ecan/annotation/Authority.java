package com.ecan.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * 权限控制
 * @author TaneRoom
 * @date 2016-07-07 21:43:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authority {

	/**资源的组权限*/
	public String[] role() default "";
	/**组权限是不是或关系，即只要满足其中之一即可，默认为是*/
    public boolean roleOr() default true;
    /**单个权限组*/
    public String[] perm() default "";
    /**单个权限是不是或关系，默认为否，即全部的单个权限必须全部满足才行*/
    public boolean permOr() default false;
	
}
