public class MainClass2 {
    public static void main(String[] args) {
        AirthmeticExpression number = new Number(2);
        AirthmeticExpression number2 = new Number(3);
        AirthmeticExpression number3 = new Number(4);
        AirthmeticExpression expression = new Expression(number2,number3,'*');
        AirthmeticExpression expression2 = new Expression(number,expression,'-');
        System.out.println(expression2.Evaluate());
    }
}
