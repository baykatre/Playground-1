package co.anilozturk.playground.calculator.history;

import co.anilozturk.playground.calculator.operation.OperationInput;
import co.anilozturk.playground.calculator.operation.OperationOutput;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class CrazyLoggerAspect {

    private final HistoryService historyService;

    @Pointcut("execution(* co.anilozturk.playground.calculator.CalculatorController.*(..))")
    private void selectCalculatorControllerMethods(){

    }

    @AfterReturning(pointcut = "selectCalculatorControllerMethods()", returning = "returnValue")
    public void logProcess(JoinPoint joinPoint, Object returnValue) {

        log(joinPoint.getArgs(), returnValue);
    }

    private void log(Object[] params, Object returnValue) {

        if(Objects.isNull(params) && Objects.isNull(returnValue)){
            return;
        }

        if(!isCalculationMethod(params[0], returnValue)){
            return;
        }

        final OperationInput input = (OperationInput) params[0];
        final ResponseEntity responseEntity = (ResponseEntity) returnValue;
        final OperationOutput output = (OperationOutput) responseEntity.getBody();

        final History history = History.builder()
                .firstNumber(input.getFirstNumber())
                .secondNumber(input.getSecondNumber())
                .operation(input.getOperationType())
                .result(output.getResult())
                .build();

        historyService.saveHistory(history);
    }

    private boolean isCalculationMethod(Object param, Object returnValue) {
        return param instanceof OperationInput && returnValue instanceof ResponseEntity
                && ((ResponseEntity) returnValue).getBody() instanceof OperationOutput;
    }
}
