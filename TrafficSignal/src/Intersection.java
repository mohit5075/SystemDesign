import java.util.HashMap;
import java.util.Map;

public class Intersection {
    Map<Direction,TrafficLight> intersection = new HashMap<>();
    public void addLight(TrafficLight trafficLight){
        intersection.putIfAbsent(trafficLight.getDirection(),trafficLight);
    }
    public TrafficLight getLight(Direction direction){
        return intersection.get(direction);
    }
}
