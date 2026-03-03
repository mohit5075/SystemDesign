public class Character {
    private char ch;
    private TextStyle textStyle;

    public Character(char ch, TextStyle textStyle) {
        this.ch = ch;
        this.textStyle = textStyle;
    }

    public char getCh() {
        return ch;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }
}
