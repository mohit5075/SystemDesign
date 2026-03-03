import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private List<List<Character>> editor;
    public TextEditor(){
        editor = new ArrayList<>();
    }
    public void addCharacter(int row,int col,Character character){
        if(editor.size()<=row){
            editor.add(new ArrayList<>());
            row=editor.size()-1;
        }
        ArrayList<Character> list = (ArrayList<Character>) editor.get(row);
        if(list.size()<=col){
            list.add(character);
            return;
        }
        list.add(col,character);
    }

    public Character getCharacter(int row,int col){
        if(editor.size()<=row){
            return null;
        }
        ArrayList<Character> list = (ArrayList<Character>) editor.get(row);
        if(list.size()<=col){
            return null;
        }
        return list.get(col);
    }

    public void deleteCharacter(int row,int col){
        if(editor.size()<=row){
            return;
        }
        ArrayList<Character> list = (ArrayList<Character>) editor.get(row);
        if(list.size()<=col){
            return;
        }
        list.remove(col);
    }

    public String readLine(int row){
        if(row>=editor.size()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Character character : editor.get(row)){
            stringBuilder.append(character.getCh());
        }
        return stringBuilder.toString();
    }
}
