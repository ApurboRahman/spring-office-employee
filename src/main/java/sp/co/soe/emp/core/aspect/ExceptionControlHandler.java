package sp.co.soe.emp.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionControlHandler {

    @Around("execution(* sp.co.soe.emp..*(..)) && @annotation(exceptionControl)")
    public Object exceptionThrowable(ProceedingJoinPoint joinPoint, ExceptionControl exceptionControl) throws Throwable {
        Object proceed = joinPoint.proceed();

        return proceed;

    }
}
