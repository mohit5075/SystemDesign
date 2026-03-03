public class ExtraPaneer implements PizzaDecorator{
    private Pizza pizza;
    public ExtraPaneer(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double getCost() {
        return pizza.getCost()+50;
    }

    @Override
    public String getDescription() {
        return "Pizza with Extra Paneer Topping";
    }
}
