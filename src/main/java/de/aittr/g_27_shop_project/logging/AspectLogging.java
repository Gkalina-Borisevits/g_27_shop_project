package de.aittr.g_27_shop_project.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);



//    @Pointcut("execution(* de.aittr.g_27_shop_project.services.jpa." +
//            "JpaProductService.getAllActiveProducts(..))")
//    public void getProducts() {}

//    @Before("allMethodsInJpaProductService()")
//    public void beforeSaveProduct(JoinPoint joinPoint) { logger.info("Вызван метод save");}
//    @After("allMethodsInJpaProductService()")
//    public void afterSaveProduct(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        logger.info(String.format("Метод save вызван с параметрами %s", args[0]));
//    }

  //  @Pointcut("execution(* de.aittr.g_27_shop_project.services.jpa." +
//            "JpaProductService.getActiveProductById(..))")
//    public void getProduct() {}

@Pointcut("within(de.aittr.g_27_shop_project.services.jpa.JpaProductService)")
public void allMethodsInJpaProductService() {}

    @Before("allMethodsInJpaProductService()")
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info(String.format("Вызван метод %s", joinPoint.getSignature().getName()));
    }

    @AfterReturning(
            pointcut = "allMethodsInJpaProductService()",
            returning = "result"
    )
    public void afterReturningProduct(JoinPoint joinPoint, Object result) {
        logger.info(String.format("Метод %s успешно вернул объект %s", joinPoint.getSignature().getName(), result));
    }

    @AfterThrowing(
            pointcut = "allMethodsInJpaProductService()",
            throwing = "e"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        logger.info(String.format("Метод %s выбросил исключение %s", joinPoint.getSignature().getName(), e.getMessage()));
    }
}