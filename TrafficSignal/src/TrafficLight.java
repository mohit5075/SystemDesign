import java.util.UUID;

public class TrafficLight {
    private String id;
    private Direction direction;
    private Color color;
    private long greenTime;
    private long yellowTime;

    public TrafficLight(Direction direction, Color color, long greenTime, long yellowTime) {
        this.id = UUID.randomUUID().toString();
        this.direction = direction;
        this.color = color;
        this.greenTime = greenTime;
        this.yellowTime = yellowTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getGreenTime() {
        return greenTime;
    }

    public void setGreenTime(long greenTime) {
        this.greenTime = greenTime;
    }

    public long getYellowTime() {
        return yellowTime;
    }

    public void setYellowTime(long yellowTime) {
        this.yellowTime = yellowTime;
    }
}
