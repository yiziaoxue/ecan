package com.ecan.annotation.contract;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecan.annotation.RequestLimit;
import com.ecan.exception.RequestLimitException;
import com.ecan.util.HttpRequestUtil;
import com.ecan.util.RedisUtil;

/**
* @author zhenhua.chun 
* @version createtime：2016年6月13日 下午4:54:43
* @Description
* 类说明
*/

@Aspect
@Component
public class RequestLimitContract {
	private static final Logger logger = LoggerFactory.getLogger("RequestLimitLogger");
	@Autowired
	private RedisUtil redisUtil;

	  @Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(limit)")
	  public void requestLimit(final JoinPoint joinPoint,RequestLimit limit) throws RequestLimitException {

	    try {
	      Object[] args = joinPoint.getArgs();
	      HttpServletRequest request = null;
	      for (int i = 0; i < args.length; i++) {
	        if (args[i] instanceof HttpServletRequest) {
	          request = (HttpServletRequest) args[i];
	          break;
	        }
	      }
	      if (request == null) {
	        throw new RequestLimitException("方法中缺失HttpServletRequest参数");
	      }
	      String ip = HttpRequestUtil.getIpAddress(request);
	      String url = request.getRequestURL().toString();
	      String key = "req_limit_".concat(url).concat(ip);
	      long count = redisUtil.set(key, 1);
	      if (count == 1) {
	    	  redisUtil.expire(key, limit.time());
	      }
	      if (count > limit.count()) {
	        System.out.println("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
	        throw new RequestLimitException();
	      }
	      System.out.println("用户IP[" + ip + "]第[" + count + "]次访问地址[" + url + "]");
	    } catch (RequestLimitException e) {
	      throw e;
	    } catch (Exception e) {
	      logger.error("发生异常: ", e);
	    }
	  }
}