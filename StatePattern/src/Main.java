public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(new RedSignal());
        vehicle.applySignal();

        vehicle.setSignal(new GreenSignal());
        vehicle.applySignal();

        vehicle.setSignal(new OrangeSignal());
        vehicle.applySignal();
    }
}