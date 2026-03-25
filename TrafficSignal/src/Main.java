public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight t1  = new TrafficLight(Direction.NORTH,Color.GREEN,0,0);
        TrafficLight t2  = new TrafficLight(Direction.SOUTH,Color.GREEN,0,0);
        TrafficLight t3  = new TrafficLight(Direction.EAST,Color.RED,0,0);
        TrafficLight t4  = new TrafficLight(Direction.WEST,Color.RED,0,0);
        Intersection intersection = new Intersection();
        intersection.addLight(t1);
        intersection.addLight(t2);
        intersection.addLight(t3);
        intersection.addLight(t4);
        Controller controller = new Controller(intersection);
        controller.run();
    }
}