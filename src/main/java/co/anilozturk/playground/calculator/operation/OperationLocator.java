package co.anilozturk.playground.calculator.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.Introspector;

@Component
@RequiredArgsConstructor
public class OperationLocator {

    private final ApplicationContext applicationContext;

    public Operation getOperation(OperationType operationType){

        final String operationBeanName = operationType.getBeanName();

        return applicationContext.getBean(Introspector.decapitalize(operationBeanName), Operation.class);
    }
}
