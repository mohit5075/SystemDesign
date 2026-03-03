public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2);
        ElevatorRequest request1 = new ElevatorRequest(3, Direction.UP);
        ElevatorRequest request2 = new ElevatorRequest(5, Direction.UP);
        ElevatorRequest request3 = new ElevatorRequest(2, Direction.DOWN);
        controller.handleRequest(request1);
        controller.handleRequest(request2);
        controller.handleRequest(request3);
        controller.moveElevators();
        controller.moveElevators();
        controller.moveElevators();
    }
}