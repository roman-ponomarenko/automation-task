package org.automation.task.core.aspects;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class LogStepAspect {
    @SneakyThrows
    @Around("@annotation(io.qameta.allure.Step)")
    public Object switchToIFrameBeforeExecutionAdvice(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Step annotation = method.getAnnotation(Step.class);

        log.info(annotation.value());

        return pjp.proceed(pjp.getArgs());
    }
}
