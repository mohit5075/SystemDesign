public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Marghrita();
        System.out.println("Cost: " + pizza.getCost());
        System.out.println("Description: " + pizza.getDescription());

        Pizza pizzaWithCheese = new ExtraCheese(new Marghrita());
        System.out.println("Cost: " + pizzaWithCheese.getCost());
        System.out.println("Description: " + pizzaWithCheese.getDescription());

        Pizza pizzaWithPaneer = new ExtraPaneer(new ExtraCheese(new Corn()));
        System.out.println("Cost: " + pizzaWithPaneer.getCost());
        System.out.println("Description: " + pizzaWithPaneer.getDescription());
    }
}