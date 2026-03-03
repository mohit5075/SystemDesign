import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> jumps = new HashMap<>();
        jumps.put(3, 22);  // Ladder from 3 to 22
        jumps.put(5, 8);   // Ladder from 5 to 8
        jumps.put(11, 26); // Ladder from 11 to 26
        jumps.put(20, 29); // Ladder from 20 to 29
        jumps.put(17, 4);  // Snake from 17 to 4
        jumps.put(19, 7);  // Snake from 19 to 7
        jumps.put(27, 1);  // Snake from 27 to 1
        Board board = new Board(100, jumps);
        Dice dice = new Dice();
        Queue<Player> players = new LinkedList<>();
        players.add(new Player("Mohit"));
        players.add(new Player("Bharti"));
        Game game = new Game(board, dice, players);
        game.start();
    }
}