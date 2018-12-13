package spring.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 切面类必须也加入IOC容器中
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* spring.demo.service.ReadWriteDemoService.*(..))")
    public void cutMethod(){
    }

    @Before(value="cutMethod()")
    public void beforeAdvisor(){
        System.out.println("*******before-deal*******");
    }

    @After(value="cutMethod()")
    public void afterAdvisor(){
        System.out.println("*******after-deal*******");
    }
}
