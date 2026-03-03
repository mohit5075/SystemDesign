import java.util.Queue;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;
    public Game(Board board, Dice dice, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }
    public void start(){
        while(true){
            Player player = players.poll();
            int roll = dice.roll();
            int newPosition = player.getPosition()+roll;
            if(newPosition > board.getSize()){
                players.add(player);
                continue;
        }
            if(board.getJumps().containsKey(newPosition)){
                newPosition = board.getJumps().get(newPosition);
            }
            player.setPosition(newPosition);
            System.out.println(player.getName() + " rolled a " + roll + " and moved to position " + newPosition);
            if(newPosition == board.getSize()){
                System.out.println(player.getName() + " wins the game!");
                break;
            }
            players.add(player);
        }
    }
}
