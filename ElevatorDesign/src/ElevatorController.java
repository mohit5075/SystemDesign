import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    List<Elevator> elevators;
    private ElevatorStrategy elevatorStrategy;
    public ElevatorController(int numberOfElevators){
        elevators = new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            elevators.add(new Elevator(i));
        }
        elevatorStrategy = new ElevatorStrategy();
    }
    public void handleRequest(ElevatorRequest request){
        Elevator assignedElevator = elevatorStrategy.selectElevator(request, elevators);
        assignedElevator.addRequest(request);
        System.out.println("Elevator " + assignedElevator.getId() + " assigned to floor " + request.getFloor());
    }

    public void moveElevators(){
        for(Elevator elevator : elevators){
            elevator.move();
        }
    }
}
