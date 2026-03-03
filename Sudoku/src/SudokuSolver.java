import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class SudokuSolver {
    private Deque<Player> players;
    private Board board;
    public SudokuSolver(Board board, Deque<Player> players){
        this.board = board;
        this.players = players;
    }
    public void startGame(){
        while (true) {
            Player player = players.getFirst();
            System.out.println("Sudoku state:");
            board.printBoard();
            System.out.println(player.getName() + " chance. Please enter row,col and value");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);
            int val = Integer.valueOf(values[2]);
            if (board.isValid(row, col, val)) {
                board.setValue(row, col, val);
                if (board.isOver()) {
                    System.out.println("Winner is: " + player.getName());
                    break;
                }
            } else {
                System.out.println("Invalid move. Input again: ");
                players.addFirst(player);
            }
        }
    }
}
