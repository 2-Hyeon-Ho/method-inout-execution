package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.example.LogExecution)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method called : {}", methodName);
        logger.info("Input arguments : ");
        for (Object arg : args) {
            logger.info(" - {}", arg);
        }

        Object result;
        try{
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.debug("Method : {} threw an exception : {}", methodName, throwable.toString());
            throw throwable;
        }

        logger.info("Method : {} returned : {}", methodName, result);
        return result;
    }
}
