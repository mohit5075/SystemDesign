public class Number implements AirthmeticExpression{
    private int number;
    public Number(int number){
        this.number = number;
    }
    @Override
    public int Evaluate() {
        System.out.println("Number is: "+number);
        return number;
    }
}
