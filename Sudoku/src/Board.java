public class Board {
    private Cell[][] board = new Cell[9][9];
    private int emptyCells=81;
    public Board(){

    }
    public void setValue(int row,int col, int val){
        Cell cell = board[row][col];
        cell.setValue(val);
        emptyCells--;
    }
    public int getValue(int row,int col){
        return board[row][col].getValue();
    }
    public boolean isValid(int row,int col,int val){
        for(int i=0;i<9;i++){
            if(board[i][col].getValue()==val)return false;
        }
        for(int i=0;i<9;i++){
            if(board[row][i].getValue()==val)return false;
        }
        int br = (row/3)*3;
        int bc = (col/3)*3;
        for(int r=br;r<=br+2;r++){
            for(int c = bc;c<=bc+2;bc++){
                if(board[br][bc].getValue()==val)return false;
            }
        }
        return true;
    }
    public boolean isOver(){
        return emptyCells==0;
    }
    public void printBoard(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j].getValue()+" ");
            }
            System.out.println();
        }
    }
}
