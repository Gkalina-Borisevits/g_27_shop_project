package de.aittr.g_27_shop_project.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspectLogging {

    private Logger logger = LoggerFactory.getLogger(ServiceAspectLogging.class);

    @Pointcut("within(de.aittr.g_27_shop_project.services..*)")
    public void allMethodsInService() {}

    @Before("allMethodsInService()")
    public void beforeMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(String.format("В классе %s, вызван метод %s", className, methodName));
    }

    @AfterReturning(
            pointcut = "allMethodsInService()",
            returning = "result"
    )
    public void afterReturningProduct(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(String.format("В классе %s, метод %s успешно вернул объект %s", className, methodName, result));
    }

    @AfterThrowing(
            pointcut = "allMethodsInService()",
            throwing = "e"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(String.format("В классе %s, метод %s выбросил исключение -  %s", className, methodName, e.getMessage()));
    }
}
