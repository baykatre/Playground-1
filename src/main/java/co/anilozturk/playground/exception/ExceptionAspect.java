package co.anilozturk.playground.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    public static final String UNKNOWN_ERROR = "UNKNOWN ERROR!";

    @Pointcut("execution(* co.anilozturk.playground..*.*(..))")
    //@Pointcut("execution(* (@org.springframework.web.bind.annotation.RestController *).*(..))")
    private void selectAll() {

    }

    @Around("selectAll()")
    public Object wrapException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        }
        catch (PlayException exception) {
            throw exception;
        }
        catch (Exception exception) {
            throw new PlayException(UNKNOWN_ERROR);
        }
    }
}
