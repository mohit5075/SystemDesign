public class ExtraCheese implements PizzaDecorator{
    private Pizza pizza;
    public ExtraCheese(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double getCost() {
        return pizza.getCost()+30;
    }

    @Override
    public String getDescription() {
        return "Pizza with Extra Cheese Topping";
    }
}
