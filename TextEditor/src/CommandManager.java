import java.util.Stack;

public class CommandManager {
    private Stack<Command>undoStack = new Stack<>();
    private Stack<Command>redoStack = new Stack<>();
    public void execute(Command command){
        command.execute();
        redoStack.clear();
        undoStack.push(command);
    }
    public void undo(){
        if(undoStack.isEmpty())return;
        Command command = undoStack.peek();
        command.undo();
        undoStack.pop();
        redoStack.push(command);
    }
    public void redo(){
        if(redoStack.isEmpty())return;
        Command command = redoStack.peek();
        command.execute();
        redoStack.pop();
        undoStack.push(command);
    }
}
