package com.sapient.springdemo.aspects;

import com.sapient.springdemo.model.Employee;
import com.sapient.springdemo.service.EmployeeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.sapient.springdemo.service.EmployeeServiceImpl.*(..))")
    public void logBefore(JoinPoint target) {
        System.out.println("------------logging before the method is getting executed-------------------");
        System.out.println(target.getArgs()[0]);
        System.out.println(target.getTarget() instanceof EmployeeService);
    }

    @Around("execution(* com.sapient.springdemo.service.EmployeeServiceImpl.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) {
        System.out.println("------------logging before the method is getting executed-------------------");
        if(joinPoint.getArgs()[0] instanceof Employee){
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        System.out.println("-------------------Logging after the successfull execution of the method -----------------");
    }
}