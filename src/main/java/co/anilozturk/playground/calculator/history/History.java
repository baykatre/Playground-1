package co.anilozturk.playground.calculator.history;

import co.anilozturk.playground.calculator.operation.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CALCULATOR_HISTORY")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = OperationTypeConverter.class)
    private OperationType operation;

    private Long firstNumber;

    private Long secondNumber;

    private Double result;
}
