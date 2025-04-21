package com.example.userservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.userservice.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[START] Method: " + joinPoint.getSignature().getName() + ", Args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.example.userservice.controller.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("[END] Method: " + joinPoint.getSignature().getName() + ", Response: " + result);
    }
}
