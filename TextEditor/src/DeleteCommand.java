public class DeleteCommand implements Command{
    private TextEditor textEditor;
    private Character character;
    private int row;
    private int col;
    public DeleteCommand(TextEditor textEditor,int row,int col,Character character){
        this.row = row;
        this.col = col;
        this.textEditor = textEditor;
        this.character = character;
    }
    @Override
    public void execute() {
        textEditor.deleteCharacter(row,col);
    }

    @Override
    public void undo() {
        textEditor.addCharacter(row,col,character);
    }
}
