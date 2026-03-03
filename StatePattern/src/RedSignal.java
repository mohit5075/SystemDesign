public class RedSignal implements Signal{
    @Override
    public void instruction(Vehicle vehicle) {
        System.out.println("Stop Vehicle");
        vehicle.setSignal(new GreenSignal());
    }
}
