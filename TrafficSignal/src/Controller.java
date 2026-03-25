public class Controller {
    private final Intersection intersection;

    public Controller(Intersection intersection) {
        this.intersection = intersection;
    }
    public void run() throws InterruptedException {
        while(true){
            setGreen(Direction.NORTH,Direction.SOUTH);
            setRed(Direction.EAST,Direction.WEST);
            System.out.println("Green: north,south, Red: east,west for 5 sec");
            Thread.sleep(5000);
            setYellow(Direction.NORTH,Direction.SOUTH);
            System.out.println("Yellow: north,south for 2 sec");
            Thread.sleep(2000);
            setGreen(Direction.EAST,Direction.WEST);
            setRed(Direction.NORTH,Direction.SOUTH);
            System.out.println("Green: east,west, Red: north,south for 5 sec");
            Thread.sleep(5000);
            setYellow(Direction.EAST,Direction.WEST);
            System.out.println("Yellow: east,west for 2 sec");
            Thread.sleep(2000);
        }
    }
    private void setGreen(Direction... directions){
        for(Direction direction : directions){
            intersection.getLight(direction).setColor(Color.GREEN);
        }
    }
    private void setYellow(Direction... directions){
        for(Direction direction : directions){
            intersection.getLight(direction).setColor(Color.YELLOW);
        }
    }
    private void setRed(Direction... directions){
        for(Direction direction : directions){
            intersection.getLight(direction).setColor(Color.RED);
        }
    }
}
