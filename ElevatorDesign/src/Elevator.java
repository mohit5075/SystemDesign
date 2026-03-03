import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {
    int id;
    int floor;
    Direction direction = Direction.IDLE;
    PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    PriorityQueue<Integer> downQueue = new PriorityQueue<>(Comparator.reverseOrder());
    public Elevator(int id){
        this.id = id;
        this.floor = 0;
    }
    public int getId() {
        return id;
    }
    public void addRequest(ElevatorRequest request){
       if(floor<request.getFloor()){
           upQueue.add(request.getFloor());
       } else {
           downQueue.add(request.getFloor());
       }
    }
    public void move(){

            if(!upQueue.isEmpty()){
                floor = upQueue.poll();
                direction = Direction.UP;
                System.out.println("Elevator " + id + " moved to floor " + floor+" move up");
            } else if(!downQueue.isEmpty()){
            direction = Direction.DOWN;
                floor = downQueue.poll();
                System.out.println("Elevator " + id + " moved to floor " + floor+"move down");
            }else{
                direction = Direction.IDLE;
                System.out.println("Elevator " + id + " is idle at floor " + floor);
        }
    }
}
