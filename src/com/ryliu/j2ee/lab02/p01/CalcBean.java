package com.ryliu.j2ee.lab02.p01;

/**
 * The calculation JavaBean for simple calculator.
 */
public class CalcBean {

    public CalcBean() {
        // empty
    }

    private Long operation1;

    private Long operation2;

    private String operator;

    public void setOperation1(Long operation1) {
        this.operation1 = operation1;
    }

    public Long getOperation1() {
        return operation1;
    }

    public void setOperation2(Long operation2) {
        this.operation2 = operation2;
    }

    public Long getOperation2() {
        return operation2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    /**
     * Calculate the result according to operations and operator.
     *
     * @return the result.
     */
    public Long calc() {
        Long result;
        switch (operator.charAt(0)) {
        case '+':
            result = operation1 + operation2;
            break;
        case '-':
            result = operation1 - operation2;
            break;
        case '*':
            result = operation1 * operation2;
            break;
        default:
            result = null;
        }
        return result;
    }
}
