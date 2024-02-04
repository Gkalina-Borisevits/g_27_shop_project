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
        logger.info(String.format("Вызван метод %s", joinPoint.getSignature().getName()));
    }
    @AfterReturning(
            pointcut = "allMethodsInService()",
            returning = "result"
    )
    public void afterReturningProduct(JoinPoint joinPoint, Object result) {
        logger.info(String.format("Метод %s успешно вернул объект %s", joinPoint.getSignature().getName(), result));
    }

    @AfterThrowing(
            pointcut = "allMethodsInService()",
            throwing = "e"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        logger.info(String.format("Метод %s выбросил исключение %s", joinPoint.getSignature().getName(), e.getMessage()));
    }
}
