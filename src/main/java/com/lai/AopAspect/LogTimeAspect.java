package com.lai.AopAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/9/20.
 */
@Aspect
@Order(2) //表示多个切面的优先级
@Component
public class LogTimeAspect {
    private static Logger logger= LoggerFactory.getLogger(LogTimeAspect.class);

    @Pointcut("execution(public * com.lai.web..*.*(..))")
    public void LogTime(){}

    @Around("LogTime()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable{
        Long startTime=System.currentTimeMillis();
        //doBefore(point);
        Object result=point.proceed();
        //doAfterReturning(ret);
        Long endTime=System.currentTimeMillis();
        logger.info("耗时："+(endTime-startTime));
        return result;
    }
}
