public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(ElevatorRequest elevatorRequest);
}
