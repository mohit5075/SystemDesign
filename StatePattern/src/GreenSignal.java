public class GreenSignal implements Signal{
    @Override
    public void instruction(Vehicle vehicle) {
        System.out.println("Move Vehicle");
        vehicle.setSignal(new RedSignal());
    }
}
