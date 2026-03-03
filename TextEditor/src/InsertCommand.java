public class InsertCommand implements Command{
    private TextEditor textEditor;
    private int row;
    private int col;
    private Character character;
    public InsertCommand(TextEditor textEditor,int row,int col,Character character){
        this.textEditor = textEditor;
        this.row = row;
        this.character = character;
        this.col = col;
    }
    @Override
    public void execute() {
        textEditor.addCharacter(row,col,character);
    }

    @Override
    public void undo() {
        textEditor.deleteCharacter(row,col);
    }
}
