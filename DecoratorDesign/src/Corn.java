public class Corn implements Pizza{
    @Override
    public double getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Corn Pizza";
    }
}
