package org.automation.task.core.aspects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.automation.task.core.annotations.InIFrame;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Aspect
@Slf4j
@Component
public class InIFrameAspect {

    @SneakyThrows
    @Around("@annotation(org.automation.task.core.annotations.InIFrame)")
    public Object switchToIFrameBeforeExecutionAdvice(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        InIFrame annotation = method.getAnnotation(InIFrame.class);

        SelenideElement iframeElement = $(annotation.how().buildBy(annotation.locator())).shouldBe(visible);
        Selenide.sleep(Duration.ofSeconds(1).toMillis());
        Selenide.switchTo().frame(iframeElement);
        log.warn("Switched to iframe '{}'", annotation.locator());

        Object invocationResult = pjp.proceed(pjp.getArgs());

        Selenide.switchTo().defaultContent();
        log.warn("Switched to default content frame");

        return invocationResult;
    }
}
