public class Expression implements AirthmeticExpression{
    private AirthmeticExpression leftExpression;
    private AirthmeticExpression rightExpression;
    private char operator;
    public Expression(AirthmeticExpression leftExpression, AirthmeticExpression rightExpression, char operator){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }
    @Override
    public int Evaluate() {
        switch (operator){
            case '+':
                return leftExpression.Evaluate()+rightExpression.Evaluate();
            case '-':
                return leftExpression.Evaluate()-rightExpression.Evaluate();
            case '*':
                return leftExpression.Evaluate()*rightExpression.Evaluate();
            default:
                return leftExpression.Evaluate()/rightExpression.Evaluate();
        }
    }
}
