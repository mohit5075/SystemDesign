public class Vehicle {
    private Signal signal;

    public Vehicle(Signal signal) {
        this.signal = signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public void applySignal() {
        signal.instruction(this);
    }
}
