import java.util.List;

import static java.lang.Math.abs;

public class ElevatorStrategy {
    Elevator selectElevator(ElevatorRequest request, List<Elevator> elevators) {
        int floor = request.getFloor();
        int distance = Integer.MAX_VALUE;
        Elevator e = null;
        for (Elevator elevator : elevators) {
            if (abs(elevator.floor - floor) < distance) {
                distance = abs(elevator.floor - floor);
                e = elevator;
            }
        }
        return e;
    }
}
