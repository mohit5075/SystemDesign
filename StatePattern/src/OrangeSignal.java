public class OrangeSignal implements Signal{
    @Override
    public void instruction(Vehicle vehicle) {
        System.out.println("Warn Vehicle");
        vehicle.setSignal(new RedSignal());
    }
}
