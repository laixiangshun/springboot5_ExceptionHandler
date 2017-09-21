package com.lai.AopAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by lailai on 2017/9/20.
 * AOP切面编程-切面类
 * 使用@Aspect注解将一个java类定义为切面类
 * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等
 * 使用@Before在切入点开始处切入内容
 * 使用@After在切入点结尾处切入内容
 * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 * 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 * 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private static Logger logger= LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> time=new ThreadLocal<>(); //避免同步问题
    @Pointcut("execution(public * com.lai.web..*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        time.set(System.currentTimeMillis());
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //记录请求内容
        logger.info("URL:"+request.getRequestURI().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("PORT:"+request.getServerPort());
        logger.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ARGS:"+ Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理完请求，返回内容
        logger.info("RESPONSE:"+ret);
        logger.info("SPEND TIME:"+(System.currentTimeMillis()-time.get()));
    }
//    @Around(value = "webLog()")
//    public Object doAround(ProceedingJoinPoint point) throws Throwable{
//        Long startTime=System.currentTimeMillis();
//        //doBefore(point);
//        Object result=point.proceed();
//        //doAfterReturning(ret);
//        Long endTime=System.currentTimeMillis();
//        logger.info("耗时："+(endTime-startTime));
//        return result;
//    }
}
