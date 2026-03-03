import java.util.HashMap;

public class Board {
    private int size;
    private HashMap<Integer,Integer> jumps;

    public Board(int size, HashMap<Integer,Integer> jumps) {
        this.size = size;
        this.jumps = jumps;
    }

    public int getSize() {
        return size;
    }

    public HashMap<Integer, Integer> getJumps() {
        return jumps;
    }
}
